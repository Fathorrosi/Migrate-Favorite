package com.permata.migrate.service;

import com.permata.migrate.entity.mysql.ImgIdGenerator;
import com.permata.migrate.entity.mysql.PermataFavorite;
import com.permata.migrate.repository.db2.DB2PermataFavoriteRepository;
import com.permata.migrate.repository.mysql.MySqlImgIdGeneratorRepository;
import com.permata.migrate.repository.mysql.MySqlPermataFavoriteRepository;
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


    List<String> tempImageGCN = new ArrayList<>();
    int recordSizePerProcess;
    int conterSavedRecord;


    public PermataFavoriteService() {
    }

    public void dataMigrationPermataFavorite(int recordSizePerProcess) {
        System.out.println("-------------- Start migrating permata favorite ----------------------");
        this.recordSizePerProcess = recordSizePerProcess;

//        mySqlPermataFavoriteRepository.updateCollation();

        //Priorities duplicate GCN record to be saved
        insertDuplicateGcn();

        //Continuing process for non duplicate GCN
        int totalPermataFavorite = db2PermataFavoriteRepository.countAllData();

        System.out.println("\n==================================================================");
        System.out.println(" Saving not duplicate GCN records ");
        System.out.println("==================================================================\n");

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
        Insert Duplicate GCN
        Description : method for searching and saving duplicate GCN to optimize image id generation and migration process
     */
    public void insertDuplicateGcn() {
        System.out.println("\n==================================================================");
        System.out.println(" Saving duplicate GCN records ");
        System.out.println("==================================================================\n");

        int sizeRecordWithDuplicateGcn = db2PermataFavoriteRepository.countRecordWithDuplicateGcn();
        System.out.println("count data : "+sizeRecordWithDuplicateGcn);


        int remainingData = sizeRecordWithDuplicateGcn % recordSizePerProcess;
        int totalFetchProcess = sizeRecordWithDuplicateGcn / recordSizePerProcess;

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

        List<com.permata.migrate.entity.mysql.PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
        List<com.permata.migrate.entity.db2.PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();

        boolean lastProcessRecord = false;

        Timestamp timestampp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Fetch Data at : " + timestampp);
        List<com.permata.migrate.entity.db2.PermataFavorite> permataFavorites = db2PermataFavoriteService.getPermataFavoriteduplicate(recordSizePerProcess);

        System.out.println("Size Get Data : " + permataFavorites.size());
        System.out.println("Preparing Data..");


        for (int i = 0; i < permataFavorites.size(); i++) {


            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
            com.permata.migrate.entity.db2.PermataFavorite permataFavoriteDB2 = new com.permata.migrate.entity.db2.PermataFavorite();
            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();

            //Make Id_Fave_Img and Insert Table Img_Id_Generator
            String idFavImage;
            int seq = 1;

            //Check and Set Frequency GCN
            int frequencyDuplicateGCN = Collections.frequency(tempImageGCN, permataFavorites.get(i).getGcn());
            seq = seq + frequencyDuplicateGCN;

            imgIdGenerator.setGcn(permataFavorites.get(i).getGcn());
            imgIdGenerator.setSequence(seq);
            ListImgIdGenerators.add(imgIdGenerator);

            idFavImage = permataFavorites.get(i).getGcn() + String.format("%04d", seq);


            //prepare in list for insert to MySql
            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteMySql.setGcn(permataFavorites.get(i).getGcn());
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

            ListPermataFavoriteMySql.add(permataFavoriteMySql);

            //update ID_Fav_Img & Status in DB2
            permataFavoriteDB2.setIdFav(permataFavorites.get(i).getIdFav());
            permataFavoriteDB2.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteDB2.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteDB2.setGcn(permataFavorites.get(i).getGcn());
            permataFavoriteDB2.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
            permataFavoriteDB2.setAction(permataFavorites.get(i).getAction());
            permataFavoriteDB2.setAliasName(permataFavorites.get(i).getAliasName());
            permataFavoriteDB2.setAmount(permataFavorites.get(i).getAmount());
            permataFavoriteDB2.setCreatedBy(permataFavorites.get(i).getCreatedBy());
            permataFavoriteDB2.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
            permataFavoriteDB2.setIdFavImage(idFavImage);
            permataFavoriteDB2.setImageExist(permataFavorites.get(i).getImageExist());
            permataFavoriteDB2.setImageData(permataFavorites.get(i).getImageData());
            permataFavoriteDB2.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
            permataFavoriteDB2.setMemo(permataFavorites.get(i).getMemo());
            permataFavoriteDB2.setSourceAccount(permataFavorites.get(i).getSourceAccount());
            permataFavoriteDB2.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
            permataFavoriteDB2.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
            permataFavoriteDB2.setStatus("Y");
            permataFavoriteDB2.setCurrency(permataFavorites.get(i).getCurrency());

            ListPermataFavoriteDB2.add(permataFavoriteDB2);

            if (lastProcessRecord == false && tempImageGCN.size() != 0) {
                if (!permataFavorites.get(i).getGcn().equals(tempImageGCN.get(tempImageGCN.size() - 1))) {
                    tempImageGCN.clear();
                }
            }

            tempImageGCN.add(permataFavorites.get(i).getGcn());


        }
        //Save remaining record to DB
        Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Save Start at : " + timestamp);

        System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
        mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);

        System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
        mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);

        System.out.println("save DB2 - Data = " + ListPermataFavoriteDB2.size());
        db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);

        Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Done at : " + timestamp2);


        conterSavedRecord = conterSavedRecord + ListPermataFavoriteMySql.size();
        System.out.println("\n Saved data : " + conterSavedRecord);
        System.out.println();

    }

    @Transactional
    public void savePermataFavorite(int data) {
        List<PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
        List<com.permata.migrate.entity.db2.PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();

//        db1PermataFavoriteRepository.UpdateStatus2(data);
        Timestamp timestampp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Fetch Data at : " + timestampp);
        List<com.permata.migrate.entity.db2.PermataFavorite> permataFavorites = db2PermataFavoriteRepository.getPermataFavorite(data);
        System.out.println("Size Get Data : " + permataFavorites.size());

        Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Start at : " + timestamp);

        for (int i = 0; i < permataFavorites.size(); i++) {

            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
            com.permata.migrate.entity.db2.PermataFavorite permataFavoriteDB2 = new com.permata.migrate.entity.db2.PermataFavorite();
            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();

            //Make Id_Fave_Img and Insert Table Img_Id_Generator
            String convertedSequence;
            int seq = 1;

            imgIdGenerator.setGcn(permataFavorites.get(i).getGcn());
            imgIdGenerator.setSequence(seq);
            ListImgIdGenerators.add(imgIdGenerator);


            convertedSequence = permataFavorites.get(i).getGcn() + String.format("%04d", seq);

            //prepare in list for insert to MySql
            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteMySql.setGcn(permataFavorites.get(i).getGcn());
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

            ListPermataFavoriteMySql.add(permataFavoriteMySql);

            //update ID_Fav_Img & Status in DB2
            permataFavoriteDB2.setIdFav(permataFavorites.get(i).getIdFav());
            permataFavoriteDB2.setTransactionType(permataFavorites.get(i).getTransactionType());
            permataFavoriteDB2.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
            permataFavoriteDB2.setGcn(permataFavorites.get(i).getGcn());
            permataFavoriteDB2.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
            permataFavoriteDB2.setAction(permataFavorites.get(i).getAction());
            permataFavoriteDB2.setAliasName(permataFavorites.get(i).getAliasName());
            permataFavoriteDB2.setAmount(permataFavorites.get(i).getAmount());
            permataFavoriteDB2.setCreatedBy(permataFavorites.get(i).getCreatedBy());
            permataFavoriteDB2.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
            permataFavoriteDB2.setIdFavImage(convertedSequence);
            permataFavoriteDB2.setImageExist(permataFavorites.get(i).getImageExist());
            permataFavoriteDB2.setImageData(permataFavorites.get(i).getImageData()); //?
            permataFavoriteDB2.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
            permataFavoriteDB2.setMemo(permataFavorites.get(i).getMemo());
            permataFavoriteDB2.setSourceAccount(permataFavorites.get(i).getSourceAccount());
            permataFavoriteDB2.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
            permataFavoriteDB2.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
            permataFavoriteDB2.setStatus("Y");
            permataFavoriteDB2.setCurrency(permataFavorites.get(i).getCurrency());

            ListPermataFavoriteDB2.add(permataFavoriteDB2);

        }
        //Save record to DB
        Timestamp timestampppp = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Save Start at : " + timestampppp);

        System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
        mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
        System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
        mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);
        System.out.println("save DB2 - Data = " + ListPermataFavoriteDB2.size());
        db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);

        Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Done at : " + timestamp2);

        conterSavedRecord = conterSavedRecord + ListPermataFavoriteMySql.size();
        System.out.println("\n Saved data : " + conterSavedRecord);
        System.out.println();

    }
}
