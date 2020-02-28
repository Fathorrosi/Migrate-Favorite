//package com.permata.migrate.service;
//
//import com.permata.migrate.entity.db2.PermataFavorite;
//import com.permata.migrate.entity.mysql.ImgIdGenerator;
//import com.permata.migrate.entity.mysql.PermataAliasAccount;
//import com.permata.migrate.repository.db2.DB2PermataAliasAccountRepository;
//import com.permata.migrate.repository.db2.DB2PermataFavoriteRepository;
//import com.permata.migrate.repository.mysql.MySqlImgIdGeneratorRepository;
//import com.permata.migrate.repository.mysql.MySqlPermataAliasAccountRepository;
//import com.permata.migrate.repository.mysql.MySqlPermataFavoriteRepository;
//import com.permata.migrate.service.db2.*;
//import com.permata.migrate.service.mysql.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by HP on 31/10/2019.
// */
//@Service
//public class MigrationService {
//    @Autowired
//    MySqlImgIdGeneratorRepository mySqlImgIdGeneratorRepository;
//    @Autowired
//    DB2PermataFavoriteRepository db2PermataFavoriteRepository;
//    @Autowired
//    MySqlPermataFavoriteRepository mySqlPermataFavoriteRepository;
//    @Autowired
//    MySqlPermataAliasAccountRepository mySqlPermataAliasAccountRepository;
//    @Autowired
//    DB2PermataAliasAccountRepository db2PermataAliasAccountRepository;
//
//    //DB2
//    @Autowired
//    DB2PermataFavoriteService db2PermataFavoriteService;
//    @Autowired
//    DB2PermataAliasAccountService db2PermataAliasAccountService;
//    @Autowired
//    DB2ImgIdGeneratorService db2ImgIdGeneratorService;
//
//    //MySql
//    @Autowired
//    MySqlPermataFavoriteService mySqlPermataFavoriteService;
//    @Autowired
//    MySqlPermataAliasAccountService mySqlPermataAliasAccountService;
//    @Autowired
//    MySqlImgIdGeneratorService mySqlImgIdGeneratorService;
//
//
//    List<String> tampungGcn = new ArrayList<>();
//    int fetchDefault = 1000000;
//
//
//    public void insertDuplicateGcn() {
//        System.out.println("\n======================================");
//        System.out.println(" Save Data where having duplicat GCN");
//        System.out.println("======================================\n");
//        int sizeDuplicateGcn = db2PermataFavoriteRepository.countRecordWithDuplicateGcn(); // 2.000.007
//
//        if (sizeDuplicateGcn > fetchDefault) {
//
//            int sisaData = sizeDuplicateGcn % fetchDefault; //7 --> 2000.000 % 1000.000
//            int process = sizeDuplicateGcn / fetchDefault; //2 --> 2000.007 /1000.000
//
//            for (int a = 1; a <= process; a++) { // process --> 2
//
////                System.out.println("====================");
////                System.out.println("Process - " + a);
////                System.out.println("====================");
//                savePermataFavoriteDuplicateToList(100000); //--> 100.000
//            }
//
//            if (sisaData != 0) {
//                savePermataFavoriteDuplicateToList(sisaData);
//            }
//
//        } else {
//            savePermataFavoriteDuplicateToList(/*data*/ 100000);
//        }
//
//        System.out.println("Finish for data duplicate GCN");
//        System.out.println("=============================\n");
////        savePermataFavoriteDuplicateBulk(data);
//    }
//
//
////    public void inpuDataPermataFavorite() {
////        List<PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
////        for (int i = 1000001; i <= 1100000; i++) {
////            PermataFavorite permataFavoriteDB2 = new PermataFavorite();
////            permataFavoriteDB2.setAction("testing");
////            permataFavoriteDB2.setAliasName("testing");
////            permataFavoriteDB2.setAmount(BigDecimal.valueOf(1.00));
////            permataFavoriteDB2.setCreatedBy("rosi");
////            permataFavoriteDB2.setCreatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
////            permataFavoriteDB2.setDestinationNumber("testing");
////            permataFavoriteDB2.setGcn("gcn" + i);
////            permataFavoriteDB2.setIdFav(2000008 + i);
////            permataFavoriteDB2.setImageExist("Y");
////            permataFavoriteDB2.setInstitutionCode("testing");
////            permataFavoriteDB2.setMemo("testing");
////            permataFavoriteDB2.setSourceAccount("testing");
////            permataFavoriteDB2.setUpdatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
////            permataFavoriteDB2.setSubTransactionType("testing");
////            permataFavoriteDB2.setTransactionType("testingA " + i);
////            permataFavoriteDB2.setIdFavImage("null");
////            permataFavoriteDB2.setUpdatedBy("rosi");
////            permataFavoriteDB2.setStatus("Process");
////            ListPermataFavoriteDB2.add(permataFavoriteDB2);
////
////        }
////        db1PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
////    }
//
//    public void inpuDataPermataAliasAccount() {
//        List<com.permata.migrate.entity.db2.PermataAliasAccount> ListPermataAliasAccountDB2 = new ArrayList<>();
//        for (int i = 1; i <= 100; i++) {
//            com.permata.migrate.entity.db2.PermataAliasAccount permataAliasAccount = new com.permata.migrate.entity.db2.PermataAliasAccount();
//            permataAliasAccount.setAccountNumber("testing" + i);
//            permataAliasAccount.setAliasNumber("testing");
//            permataAliasAccount.setCategoryAlias("testing" + i);
////            permataAliasAccount.setCreatedBy("rosi");
////            permataAliasAccount.setCreatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
//            permataAliasAccount.setGcn("gcn" + i);
//            permataAliasAccount.setUpdatedBy("rosi");
//            permataAliasAccount.setUpdatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
//            permataAliasAccount.setUserId("testing" + i);
//            permataAliasAccount.setStatus("Process");
//
//            ListPermataAliasAccountDB2.add(permataAliasAccount);
//
//        }
//        db2PermataAliasAccountRepository.saveAll(ListPermataAliasAccountDB2);
//    }
//
//    public void dataMigrationPermataFavorite(int data) {
//
//        insertDuplicateGcn();
//
//        int SizePermataFavorites = db2PermataFavoriteRepository.countAllData();
//
//        int sisaData = SizePermataFavorites % data;
//        int process = SizePermataFavorites / data;
//        for (int a = 1; a <= process; a++) {
//            System.out.println("====================");
//            System.out.println("Process - " + a);
//            System.out.println("Data ke  : " + a * data);
//            System.out.println("====================");
//            savePermataFavorite(data);
//        }
//
//        if (sisaData != 0) {
//            savePermataFavorite(sisaData);
//        }
//
//    }
//
//    public void dataMigrationPermataAliasAccount(int data) {
//
//        int SizePermataAliasAccount = db2PermataAliasAccountRepository.countAllData();
//
//        int sisaData = SizePermataAliasAccount % data;
//        int process = SizePermataAliasAccount / data;
//        for (int a = 1; a <= process; a++) {
//            System.out.println("====================");
//            System.out.println("Process - " + a);
//            System.out.println("Data ke  : " + a * data);
//            System.out.println("====================");
//            savePermataAliasAccount(data);
//        }
//
//        if (sisaData != 0) {
//            savePermataAliasAccount(sisaData);
//        }
//
//    }
//
//    public void savePermataFavorite(int data) {
//        List<com.permata.migrate.entity.mysql.PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
//        List<PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
//        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();
//
////        db1PermataFavoriteRepository.UpdateStatus2(data);
//        List<PermataFavorite> permataFavorites = db2PermataFavoriteService.getPermataFavorite(data);
//        System.out.println("Size Get Data : " + permataFavorites.size());
//
//        Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
//        System.out.println("Start at : " + timestamp);
//
//        for (int i = 0; i < permataFavorites.size(); i++) {
//
//            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
//            PermataFavorite permataFavoriteDB2 = new PermataFavorite();
//            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();
//
//            //Make Id_Fave_Img and Insert Table Img_Id_Generator
//            String convertedSequence;
//            int seq = 1;
//
//            imgIdGenerator.setGcn(permataFavorites.get(i).getGcn());
//            imgIdGenerator.setSequence(seq);
//            ListImgIdGenerators.add(imgIdGenerator);
//
//
//            convertedSequence = permataFavorites.get(i).getGcn() + String.format("%04d", seq);
//
//            //prepare in list for insert to MySql
//            permataFavoriteMySql.setAction(permataFavorites.get(i).getAction());
//            permataFavoriteMySql.setAliasName(permataFavorites.get(i).getAliasName());
//            permataFavoriteMySql.setAmount(BigDecimal.valueOf(permataFavorites.get(i).getAmount()));
//            permataFavoriteMySql.setCreatedBy(permataFavorites.get(i).getCreatedBy());
//            permataFavoriteMySql.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
//            permataFavoriteMySql.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
//            permataFavoriteMySql.setGcn(permataFavorites.get(i).getGcn());
//            permataFavoriteMySql.setIdFav(permataFavorites.get(i).getIdFav());
//            permataFavoriteMySql.setImageExist(permataFavorites.get(i).getImageExist());
//            permataFavoriteMySql.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
//            permataFavoriteMySql.setMemo(permataFavorites.get(i).getMemo());
//            permataFavoriteMySql.setSourceAccount(permataFavorites.get(i).getSourceAccount());
//            permataFavoriteMySql.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
//            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
//            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
//            permataFavoriteMySql.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
//            permataFavoriteMySql.setIdFavImage(convertedSequence);
//            ListPermataFavoriteMySql.add(permataFavoriteMySql);
//
//            //update ID_Fav_Img & Status in DB2
//            permataFavoriteDB2.setAction(permataFavorites.get(i).getAction());
//            permataFavoriteDB2.setAliasName(permataFavorites.get(i).getAliasName());
//            permataFavoriteDB2.setAmount(permataFavorites.get(i).getAmount());
//            permataFavoriteDB2.setCreatedBy(permataFavorites.get(i).getCreatedBy());
//            permataFavoriteDB2.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
//            permataFavoriteDB2.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
//            permataFavoriteDB2.setGcn(permataFavorites.get(i).getGcn());
//            permataFavoriteDB2.setIdFav(permataFavorites.get(i).getIdFav());
//            permataFavoriteDB2.setImageExist(permataFavorites.get(i).getImageExist());
//            permataFavoriteDB2.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
//            permataFavoriteDB2.setMemo(permataFavorites.get(i).getMemo());
//            permataFavoriteDB2.setSourceAccount(permataFavorites.get(i).getSourceAccount());
//            permataFavoriteDB2.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
//            permataFavoriteDB2.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
//            permataFavoriteDB2.setTransactionType(permataFavorites.get(i).getTransactionType());
//            permataFavoriteDB2.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
//            permataFavoriteDB2.setIdFavImage(convertedSequence);
//            permataFavoriteDB2.setStatus("Done");
//
//            ListPermataFavoriteDB2.add(permataFavoriteDB2);
//
//        }
//        System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
//        mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
//        System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
//        mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);
//        System.out.println("save DB2 - Data = " + ListPermataFavoriteDB2.size());
//        db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
//        Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
//        System.out.println("Done at : " + timestamp2);
//    }
//
//
//    public void savePermataFavoriteDuplicateToList(int data) {
//
//
//        int mark = 0;
//        int sizeMin1 = 0;
//        int tempData = data;
//        int sisaData;
//
//        List<com.permata.migrate.entity.mysql.PermataFavorite> ListPermataFavoriteMySql = new ArrayList<>();
//        List<PermataFavorite> ListPermataFavoriteDB2 = new ArrayList<>();
//        List<com.permata.migrate.entity.mysql.ImgIdGenerator> ListImgIdGenerators = new ArrayList<>();
//
//
//        Timestamp timestampp = new java.sql.Timestamp((new Date().getTime()));
//        System.out.println("Fetch Data at : " + timestampp);
//        List<PermataFavorite> permataFavorites = db2PermataFavoriteService.getPermataFavoriteduplicate(fetchDefault);
//
//        sisaData = permataFavorites.size() % data;
//
//
////        permataFavorites.add((PermataFavorite) db1PermataFavoriteRepository.getPermataFavoriteduplicate2());
//
//        System.out.println("Size Get Data : " + permataFavorites.size());
//        System.out.println("Preparing Data..");
//
//        if (permataFavorites.size() < data) {
//            tempData = permataFavorites.size();
//        }
//
//        for (int i = 0; i < permataFavorites.size(); i++) { //--1.000.000
//            mark++;
//
//            if (i == permataFavorites.size() - 1) {
//                sizeMin1 = 1;
//            }
//
//            com.permata.migrate.entity.mysql.PermataFavorite permataFavoriteMySql = new com.permata.migrate.entity.mysql.PermataFavorite();
//            PermataFavorite permataFavoriteDB2 = new PermataFavorite();
//            ImgIdGenerator imgIdGenerator = new ImgIdGenerator();
//
//            //Make Id_Fave_Img and Insert Table Img_Id_Generator
//            String convertedSequence;
//            int seq = 1;
//
//            //Check and Set Frequency GCN
//            int sequence = Collections.frequency(tampungGcn, permataFavorites.get(i).getGcn());
//            seq = seq + sequence;
//
//            imgIdGenerator.setGcn(permataFavorites.get(i).getGcn());
//            imgIdGenerator.setSequence(seq);
//            ListImgIdGenerators.add(imgIdGenerator);
//
//
//            convertedSequence = permataFavorites.get(i).getGcn() + String.format("%04d", seq);
//
//            //prepare in list for insert to MySql
//            permataFavoriteMySql.setAction(permataFavorites.get(i).getAction());
//            permataFavoriteMySql.setAliasName(permataFavorites.get(i).getAliasName());
//            permataFavoriteMySql.setAmount(BigDecimal.valueOf(permataFavorites.get(i).getAmount()));
//            permataFavoriteMySql.setCreatedBy(permataFavorites.get(i).getCreatedBy());
//            permataFavoriteMySql.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
//            permataFavoriteMySql.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
//            permataFavoriteMySql.setGcn(permataFavorites.get(i).getGcn());
//            permataFavoriteMySql.setIdFav(permataFavorites.get(i).getIdFav());
//            permataFavoriteMySql.setImageExist(permataFavorites.get(i).getImageExist());
//            permataFavoriteMySql.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
//            permataFavoriteMySql.setMemo(permataFavorites.get(i).getMemo());
//            permataFavoriteMySql.setSourceAccount(permataFavorites.get(i).getSourceAccount());
//            permataFavoriteMySql.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
//            permataFavoriteMySql.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
//            permataFavoriteMySql.setTransactionType(permataFavorites.get(i).getTransactionType());
//            permataFavoriteMySql.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
//            permataFavoriteMySql.setIdFavImage(convertedSequence);
//            ListPermataFavoriteMySql.add(permataFavoriteMySql);
//
//            //update ID_Fav_Img & Status in DB2
//            permataFavoriteDB2.setAction(permataFavorites.get(i).getAction());
//            permataFavoriteDB2.setAliasName(permataFavorites.get(i).getAliasName());
//            permataFavoriteDB2.setAmount(permataFavorites.get(i).getAmount());
//            permataFavoriteDB2.setCreatedBy(permataFavorites.get(i).getCreatedBy());
//            permataFavoriteDB2.setCreatedTimestamp(permataFavorites.get(i).getCreatedTimestamp());
//            permataFavoriteDB2.setDestinationNumber(permataFavorites.get(i).getDestinationNumber());
//            permataFavoriteDB2.setGcn(permataFavorites.get(i).getGcn());
//            permataFavoriteDB2.setIdFav(permataFavorites.get(i).getIdFav());
//            permataFavoriteDB2.setImageExist(permataFavorites.get(i).getImageExist());
//            permataFavoriteDB2.setInstitutionCode(permataFavorites.get(i).getInstitutionCode());
//            permataFavoriteDB2.setMemo(permataFavorites.get(i).getMemo());
//            permataFavoriteDB2.setSourceAccount(permataFavorites.get(i).getSourceAccount());
//            permataFavoriteDB2.setUpdatedTimestamp(permataFavorites.get(i).getUpdatedTimestamp());
//            permataFavoriteDB2.setSubTransactionType(permataFavorites.get(i).getSubTransactionType());
//            permataFavoriteDB2.setTransactionType(permataFavorites.get(i).getTransactionType());
//            permataFavoriteDB2.setUpdatedBy(permataFavorites.get(i).getUpdatedBy());
//            permataFavoriteDB2.setIdFavImage(convertedSequence);
//            permataFavoriteDB2.setStatus("Done");
//
//            ListPermataFavoriteDB2.add(permataFavoriteDB2);
//
//            if (sizeMin1 != 1 && tampungGcn.size() != 0) {
//                if (!permataFavorites.get(i).getGcn().equals(tampungGcn.get(tampungGcn.size() - 1))) {
//                    tampungGcn.clear();
//                }
//            }
//
//            tampungGcn.add(permataFavorites.get(i).getGcn());
//
//
//            if (mark == tempData) {
//                Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
//                System.out.println("Save Start at : " + timestamp);
//                System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
//                mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
//                System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
//                mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);
//                System.out.println("save DB2 - Data = " + ListPermataFavoriteDB2.size());
//                db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
//                Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
//                System.out.println("Done at : " + timestamp2);
//
//                mark = 0;
//                ListPermataFavoriteMySql.clear();
//                ListImgIdGenerators.clear();
//                ListPermataFavoriteDB2.clear();
//
//            }
//
//        }
//
//        if (sisaData != 0 && ListPermataFavoriteMySql.size()<data && permataFavorites.size()<data) {
//            Timestamp timestamp = new java.sql.Timestamp((new Date().getTime()));
//            System.out.println("Save Start at : " + timestamp);
//            System.out.println("save MySql - Data = " + ListPermataFavoriteMySql.size());
//            mySqlPermataFavoriteRepository.saveAll(ListPermataFavoriteMySql);
//            System.out.println("save ImgIdGen - Data = " + ListImgIdGenerators.size());
//            mySqlImgIdGeneratorRepository.saveAll(ListImgIdGenerators);
//            System.out.println("save DB2 - Data = " + ListPermataFavoriteDB2.size());
//            db2PermataFavoriteRepository.saveAll(ListPermataFavoriteDB2);
//            Timestamp timestamp2 = new java.sql.Timestamp((new Date().getTime()));
//            System.out.println("Done at : " + timestamp2);
//            System.out.println();
//        }
//
//    }
//
//    public void savePermataAliasAccount(int data) {
//        db2PermataAliasAccountRepository.UpdateStatus2(data);
//        List<com.permata.migrate.entity.db2.PermataAliasAccount> permataAliasAccounts = db2PermataAliasAccountService.getAllPermataAliasAccount(data);
//        List<PermataAliasAccount> permataAliasAccountList = new ArrayList<>();
//        for (int i = 0; i < permataAliasAccounts.size(); i++) {
//
//            PermataAliasAccount permataAliasAccount = new PermataAliasAccount();
//            permataAliasAccount.setGcn(permataAliasAccounts.get(i).getGcn());
//            permataAliasAccount.setAliasNumber(permataAliasAccounts.get(i).getAliasNumber());
////            permataAliasAccount.setCreatedBy(permataAliasAccounts.get(i).getCreatedBy());
//            permataAliasAccount.setAccountNumber(permataAliasAccounts.get(i).getAccountNumber());
//            permataAliasAccount.setCategoryAlias(permataAliasAccounts.get(i).getCategoryAlias());
////            permataAliasAccount.setCreatedTimestamp(permataAliasAccounts.get(i).getCreatedTimestamp());
//            permataAliasAccount.setUpdatedBy(permataAliasAccounts.get(i).getUpdatedBy());
//            permataAliasAccount.setUpdatedTimestamp(permataAliasAccounts.get(i).getUpdatedTimestamp());
//            permataAliasAccount.setUserId(permataAliasAccounts.get(i).getUserId());
//
//            permataAliasAccountList.add(permataAliasAccount);
//
//        }
//        db2PermataAliasAccountRepository.UpdateStatus3();
//        mySqlPermataAliasAccountRepository.saveAll(permataAliasAccountList);
//    }
//
//    /*
//    public void updateIdFavImg(String idFavImg, String idFavImgChanged) {
//        db1PermataFavoriteRepository.updateDBSource(idFavImg, idFavImgChanged);
//
//    }
//
//    public void updateStatus(String gcn) {
//        db1PermataFavoriteRepository.updateDBSourceStatus(gcn);
//
//    }
//
//    public void updateIdFavImg() {
//        List<com.permata.migrate.entity.db2.PermataFavorite> permataFavorites = db1PermataFavoriteService.getAllPermataFavorite();
//
//        for (int i = 1; i <= permataFavorites.size(); i++) {
//
////			updateStatus(permataFavorites.get(0).getGcn());
//            db1PermataFavoriteRepository.updateIdFavImg(permataFavorites.get(i).getGcn());
//
//        }
//    }
//    */
//
//
//}
