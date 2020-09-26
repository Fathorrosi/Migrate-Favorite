package com.permata.migrate.service;

import com.permata.migrate.conn.UpdateFavorite;
import com.permata.migrate.entity.mysql.ImgIdGenerator;
import com.permata.migrate.entity.mysql.PermataFavorite;
import com.permata.migrate.entity.mysql2.Image;
import com.permata.migrate.repository.db2.DB2PermataFavoriteRepository;
import com.permata.migrate.repository.mysql.MySqlImgIdGeneratorRepository;
import com.permata.migrate.repository.mysql.MySqlPermataFavoriteRepository;
import com.permata.migrate.repository.mysql2.MySqlFavImageRepo;
import com.permata.migrate.service.db2.DB2PermataFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 31/10/2019.
 */
@Service
public class PermataFavoriteService {
    @Autowired
    MySqlImgIdGeneratorRepository mySqlImgIdGeneratorRepository;
    @Autowired
    DB2PermataFavoriteRepository db2PermataFavoriteRepository;
    @Autowired
    DB2PermataFavoriteService db2PermataFavoriteService;
    @Autowired
    MySqlPermataFavoriteRepository mySqlPermataFavoriteRepository;
    @Autowired
    MySqlFavImageRepo mySqlFavImageRepo;


    private List<String> tempImageCustRefId = new ArrayList<>();
    private int recordSizePerProcess;
    private int conterSavedRecord;

    @Autowired
    public UpdateFavorite updateFavorite;

    public PermataFavoriteService() {
    }

    public void dataMigrationPermataFavorite(int recordSizePerProcess) {
        System.out.println("-------------- Start migrating permata favorite ----------------------");
        this.recordSizePerProcess = recordSizePerProcess;

//        mySqlPermataFavoriteRepository.updateCollation();

        //Priorities duplicate CustRefId record to be saved
        insertDuplicateCustRefId();

        //Continuing process for non duplicate CustRefId
        int totalPermataFavorite = db2PermataFavoriteRepository.countAllData();

        System.out.println("\n==================================================================");
        System.out.println(" Saving not duplicate GCN records ");
        System.out.println("==================================================================");

        System.out.println("count data : "+db2PermataFavoriteRepository.countPermataFavoriteNotDuplicate());

        int remainingData = totalPermataFavorite % recordSizePerProcess;
        int totalFetchProcess = totalPermataFavorite / recordSizePerProcess;
        for (int a = 1; a <= totalFetchProcess; a++) {
            System.out.println("==================================================================");
            System.out.println("Process - " + a);
            System.out.println("Data ke  : " + a * recordSizePerProcess);
            System.out.println("==================================================================");
            savePermataFavorite(recordSizePerProcess);
        }

        if (remainingData != 0) {
            System.out.println("Remaining Data");
            savePermataFavorite(remainingData);
        }

        System.out.println("Finish saving not duplicate GCN records");
        System.out.println("==================================================================\n");

    }

    /*
        Insert Duplicate CustRefId
        Description : method for searching and saving duplicate CustRefId to optimize image id generation and migration process
     */
    public void insertDuplicateCustRefId() {
        System.out.println("\n==================================================================");
        System.out.println(" Saving duplicate GCN records ");
        System.out.println("==================================================================");

        int sizeRecordWithDuplicateCustRefId = db2PermataFavoriteRepository.countRecordWithDuplicateCustRefId();
        System.out.println("count data : "+sizeRecordWithDuplicateCustRefId);


        int remainingData = sizeRecordWithDuplicateCustRefId % recordSizePerProcess;
        int totalFetchProcess = sizeRecordWithDuplicateCustRefId / recordSizePerProcess;

        for (int a = 1; a <= totalFetchProcess; a++) {
            System.out.println("==================================================================");
            System.out.println("Process - " + a);
            System.out.println("Data ke  : " + a * recordSizePerProcess);
            System.out.println("==================================================================");
            savePermataFavoriteDuplicateBulk(recordSizePerProcess);
        }

        if (remainingData != 0) {
            System.out.println("Remaining Data");
            savePermataFavoriteDuplicateBulk(remainingData);
        }


        System.out.println("Finish saving duplicate GCN records");
        System.out.println("==================================================================\n");
    }

    @Transactional
    public void savePermataFavoriteDuplicateBulk(int recordSizePerProcess) {

        String idFav = "";
        String whenIdFavImage = "";
        String whenIsMigrate = "";

        List<com.permata.migrate.entity.mysql.PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
        List<Image> imageList = new ArrayList<>();
        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();

        boolean lastProcessRecord = false;

        Timestamp timestampp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Fetch Data at : " + timestampp);
        List<com.permata.migrate.entity.db2.PermataFavorite> permataFavorites = db2PermataFavoriteService.getPermataFavoriteduplicate(recordSizePerProcess);

        System.out.println("Size Get Data : " + permataFavorites.size());
        System.out.println("Preparing Data..");


        for (int i = 0; i < permataFavorites.size(); i++) {


            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
            Image image = new Image();
            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();

            //Make Id_Fave_Img and Insert Table Img_Id_Generator
            String idFavImage;
            int seq = 1;

            //Check and Set Frequency CustRefId
            int frequencyDuplicateCustRefId = Collections.frequency(tempImageCustRefId, permataFavorites.get(i).getGcn());
            seq = seq + frequencyDuplicateCustRefId;

            imgIdGenerator.setCustRefId(permataFavorites.get(i).getGcn());
            imgIdGenerator.setSequence(seq);
            ListImgIdGenerators.add(imgIdGenerator);

            idFavImage = permataFavorites.get(i).getGcn() + String.format("%04d", seq);


            //prepare insert to MySql
            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteMySql.setCustRefId(permataFavorites.get(i).getGcn());
            permataFavoriteMySql.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
            permataFavoriteMySql.setAction(permataFavorites.get(i).getAction());
            permataFavoriteMySql.setAliasName(permataFavorites.get(i).getAliasName());
            permataFavoriteMySql.setAmount(BigDecimal.valueOf(permataFavorites.get(i).getAmount()));
            permataFavoriteMySql.setCreatedBy(permataFavorites.get(i).getCreatedBy());
            permataFavoriteMySql.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
            permataFavoriteMySql.setIdFav(permataFavorites.get(i).getIdFav());
            permataFavoriteMySql.setIdFavImage(idFavImage);
            permataFavoriteMySql.setImageExist(permataFavorites.get(i).getImageExist());
            permataFavoriteMySql.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
            permataFavoriteMySql.setMemo(permataFavorites.get(i).getMemo());
            permataFavoriteMySql.setSourceAccount(permataFavorites.get(i).getSourceAccount());
            permataFavoriteMySql.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
            permataFavoriteMySql.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
            permataFavoriteMySql.setCurrency(permataFavorites.get(i).getCurrency());
//            permataFavoriteMySql.setImageData(permataFavorites.get(i).getImageData());

            ListPermataFavoriteMySql.add(permataFavoriteMySql);

            //prepare insert Image to MySql


            //update ID_Fav_Img & Status in DB2
            image.setIdFav(permataFavorites.get(i).getIdFav());
            image.setIdImage(idFavImage);
            image.setImage(permataFavorites.get(i).getImageData());
            image.setCreated_date(permataFavorites.get(i).getCreatedTimestamp());
            image.setCreated_by(permataFavorites.get(i).getCreatedBy());
            image.setLast_modified_by(permataFavorites.get(i).getUpdatedBy());
            image.setLast_modified_date(permataFavorites.get(i).getUpdatedTimestamp());

            imageList.add(image);

            // Prepare Update DB2
            if (idFav == ""){
                idFav = idFav+permataFavorites.get(i).getIdFav()+",";
            }
            if(i==permataFavorites.size()-1){
                idFav = idFav+permataFavorites.get(i).getIdFav();
            }
            else{
                idFav = idFav+permataFavorites.get(i).getIdFav()+",";
            }
            whenIdFavImage = whenIdFavImage+" when "+permataFavorites.get(i).getIdFav()+" then '"+idFavImage+"'";
            whenIsMigrate = whenIsMigrate+" when "+permataFavorites.get(i).getIdFav()+" then 'Y'";


            if (lastProcessRecord == false && tempImageCustRefId.size() != 0) {
                if (!permataFavorites.get(i).getGcn().equals(tempImageCustRefId.get(tempImageCustRefId.size() - 1))) {
                    tempImageCustRefId.clear();
                }
            }

            tempImageCustRefId.add(permataFavorites.get(i).getGcn());


        }
        //Save remaining record to DB
        Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Save Start at : " + timestamp);

        System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
        mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
        mySqlFavImageRepo.saveAll(imageList);

        System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
        mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);

        System.out.println("Update DB2");
//        db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
//        System.exit(1);
        updateFavorite.update(idFav,whenIdFavImage,whenIsMigrate);

        Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Done at : " + timestamp2);


        conterSavedRecord = conterSavedRecord + ListPermataFavoriteMySql.size();
        System.out.println("\n Saved data : " + conterSavedRecord);
        System.out.println();

    }

    @Transactional
    public void savePermataFavorite(int data) {

        String idFav = "";
        String whenIdFavImage = "";
        String whenIsMigrate = "";

        List<PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
        List<Image> imageList = new ArrayList<>();
        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();

        Timestamp timestampp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Fetch Data at : " + timestampp);
        List<com.permata.migrate.entity.db2.PermataFavorite> permataFavorites = db2PermataFavoriteRepository.getPermataFavorite(data);
        System.out.println("Size Get Data : " + permataFavorites.size());
        System.out.println("Preparing Data..");

        Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Start at : " + timestamp);

        for (int i = 0; i < permataFavorites.size(); i++) {

            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
            Image image = new Image();
            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();

            //Make Id_Fave_Img and Insert Table Img_Id_Generator
            String convertedSequence;
            int seq = 1;

            imgIdGenerator.setCustRefId(permataFavorites.get(i).getGcn());
            imgIdGenerator.setSequence(seq);
            ListImgIdGenerators.add(imgIdGenerator);


            convertedSequence = permataFavorites.get(i).getGcn() + String.format("%04d", seq);

            //prepare in list for insert to MySql
            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteMySql.setCustRefId(permataFavorites.get(i).getGcn());
            permataFavoriteMySql.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
            permataFavoriteMySql.setAction(permataFavorites.get(i).getAction());
            permataFavoriteMySql.setAliasName(permataFavorites.get(i).getAliasName());
            permataFavoriteMySql.setAmount(BigDecimal.valueOf(permataFavorites.get(i).getAmount()));
            permataFavoriteMySql.setCreatedBy(permataFavorites.get(i).getCreatedBy());
            permataFavoriteMySql.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
            permataFavoriteMySql.setIdFav(permataFavorites.get(i).getIdFav());
            permataFavoriteMySql.setIdFavImage(convertedSequence);
            permataFavoriteMySql.setImageExist(permataFavorites.get(i).getImageExist());
            permataFavoriteMySql.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
            permataFavoriteMySql.setMemo(permataFavorites.get(i).getMemo());
            permataFavoriteMySql.setSourceAccount(permataFavorites.get(i).getSourceAccount());
            permataFavoriteMySql.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
            permataFavoriteMySql.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
            permataFavoriteMySql.setCurrency(permataFavorites.get(i).getCurrency());
//            permataFavoriteMySql.setImageData(permataFavorites.get(i).getImageData());

            ListPermataFavoriteMySql.add(permataFavoriteMySql);

            //update ID_Fav_Img & Status in DB2
            image.setIdFav(permataFavorites.get(i).getIdFav());
            image.setIdImage(convertedSequence);
            image.setImage(permataFavorites.get(i).getImageData());
            image.setCreated_date(permataFavorites.get(i).getCreatedTimestamp());
            image.setCreated_by(permataFavorites.get(i).getCreatedBy());
            image.setLast_modified_by(permataFavorites.get(i).getUpdatedBy());
            image.setLast_modified_date(permataFavorites.get(i).getUpdatedTimestamp());

            imageList.add(image);


            if (idFav == ""){
                idFav = idFav+permataFavorites.get(i).getIdFav()+",";
            }
            if(i==permataFavorites.size()-1){
                idFav = idFav+permataFavorites.get(i).getIdFav();
            }
            else{
                idFav = idFav+permataFavorites.get(i).getIdFav()+",";
            }
            whenIdFavImage = whenIdFavImage+" when "+permataFavorites.get(i).getIdFav()+" then '"+convertedSequence+"'";
            whenIsMigrate = whenIsMigrate+" when "+permataFavorites.get(i).getIdFav()+" then 'Y'";


        }
        //Save record to DB
        Timestamp timestampppp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Save Start at : " + timestampppp);

        System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
        mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
        mySqlFavImageRepo.saveAll(imageList);

        System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
        mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);

        System.out.println("update DB2");
        updateFavorite.update(idFav,whenIdFavImage,whenIsMigrate);

        Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Done at : " + timestamp2);

        conterSavedRecord = conterSavedRecord + ListPermataFavoriteMySql.size();
        System.out.println("\nSaved data : " + conterSavedRecord);
        System.out.println();

    }

        public void inpuDataPermataFavorite() {
        List<com.permata.migrate.entity.db2.PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
//        com.permata.migrate.entity.db2.PermataFavorite permataFavorite = db2PermataFavoriteRepository.getPermataFavorite();
        for (int i = 1; i <= 10; i++) {
            com.permata.migrate.entity.db2.PermataFavorite permataFavoriteDB2 = new com.permata.migrate.entity.db2.PermataFavorite();
            permataFavoriteDB2.setAction("testing");
            permataFavoriteDB2.setAliasName("testing"+i);
            permataFavoriteDB2.setAmount(1);
            permataFavoriteDB2.setCreatedBy("rosi");
            permataFavoriteDB2.setCreatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
            permataFavoriteDB2.setDestinationNumber("testingg"+i);
            permataFavoriteDB2.setGcn("gcn" + i);
            permataFavoriteDB2.setIdFav(i);
            permataFavoriteDB2.setImageExist("Y");
            permataFavoriteDB2.setInstitutionCode("testing");
            permataFavoriteDB2.setMemo("testing");
            permataFavoriteDB2.setSourceAccount("testing");
            permataFavoriteDB2.setUpdatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
            permataFavoriteDB2.setSubTransactionType("testingg"+i);
            permataFavoriteDB2.setTransactionType("testingg " + i);
            permataFavoriteDB2.setIdFavImage("null");
            permataFavoriteDB2.setUpdatedBy("rosi");
            permataFavoriteDB2.setStatus(null);
//            permataFavoriteDB2.setImageData(permataFavorite.getImageData());



            ListPermataFavoriteDB2.add(permataFavoriteDB2);

        }
            db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
    }
}

