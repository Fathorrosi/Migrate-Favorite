package com.permata.migrate.service;

import com.permata.migrate.conn.UpdateAlias;
import com.permata.migrate.entity.db2.PermataAliasAccount;
import com.permata.migrate.repository.db2.DB2PermataAliasAccountRepository;
import com.permata.migrate.repository.mysql.MySqlPermataAliasAccountRepository;
import com.permata.migrate.service.db2.DB2PermataAliasAccountService;
import com.permata.migrate.service.mysql.MySqlPermataAliasAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 01/11/2019.
 */

@Service
public class PermataAliasAccountService {
    @Autowired
    DB2PermataAliasAccountRepository db2PermataAliasAccountRepository;
    @Autowired
    MySqlPermataAliasAccountRepository mySqlPermataAliasAccountRepository;
    @Autowired
    DB2PermataAliasAccountService db2PermataAliasAccountService;
    @Autowired
    MySqlPermataAliasAccountService mySqlPermataAliasAccountService;

    @Autowired
    public UpdateAlias updateAlias;

    int conterSavedRecord;

    public void dataMigrationPermataAliasAccount(int recordSizePerProcess) {

        System.out.println("-------------- Start migrating permata alias account ----------------------");

        int SizePermataAliasAccount = db2PermataAliasAccountRepository.countAllData();
        System.out.println("Count data : " + SizePermataAliasAccount);

        int remainingData = SizePermataAliasAccount % recordSizePerProcess;
        int totalFetchProcess = SizePermataAliasAccount / recordSizePerProcess;
        for (int a = 1; a <= totalFetchProcess; a++) {
            System.out.println("====================");
            System.out.println("Process - " + a);
            System.out.println("Data   : " + a * recordSizePerProcess);

            savePermataAliasAccount(recordSizePerProcess);
        }

        if (remainingData != 0) {
            System.out.println("Remaining Data");
            savePermataAliasAccount(remainingData);
        }

    }


    public void savePermataAliasAccount(int data) {
//        db1PermataAliasAccountRepository.UpdateStatus2(data);

        String custRefId = "";
        String categoryAlias = "";
        String accountNumber = "";

        Timestamp timestampFetch = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Fetch Data at : " + timestampFetch);

        List<PermataAliasAccount> permataAliasAccounts = db2PermataAliasAccountService.getAllPermataAliasAccount(data);
        List<com.permata.migrate.entity.mysql.PermataAliasAccount> permataAliasAccountListMySql = new ArrayList<>();
        List<PermataAliasAccount> permataAliasAccountListDB2 = new ArrayList<>();

        for (int i = 0; i < permataAliasAccounts.size(); i++) {

            Timestamp timestampCreate = new java.sql.Timestamp((new Date().getTime()));

            // Prepare data save mysql
            com.permata.migrate.entity.mysql.PermataAliasAccount permataAliasAccountMySql = new com.permata.migrate.entity.mysql.PermataAliasAccount();
//            permataAliasAccountMySql.setIdAlias());
            permataAliasAccountMySql.setCustRefId(permataAliasAccounts.get(i).getGcn());
            permataAliasAccountMySql.setAliasName(permataAliasAccounts.get(i).getAliasNumber()); // ?
            permataAliasAccountMySql.setCreatedBy("System");
            permataAliasAccountMySql.setAccountNumber(permataAliasAccounts.get(i).getAccountNumber());
            permataAliasAccountMySql.setCategoryAlias(permataAliasAccounts.get(i).getCategoryAlias());
            permataAliasAccountMySql.setCreatedTimestamp(timestampCreate);
            permataAliasAccountMySql.setUpdatedBy(permataAliasAccounts.get(i).getUpdatedBy());
            permataAliasAccountMySql.setUpdatedTimestamp(permataAliasAccounts.get(i).getUpdatedTimestamp());
//            permataAliasAccountMySql.setUserId(permataAliasAccounts.get(i).getUserId());

            permataAliasAccountListMySql.add(permataAliasAccountMySql);


            // Prepare data save DB2
//            PermataAliasAccount permataAliasAccountDB2 = new PermataAliasAccount();

//            permataAliasAccountDB2.setIdAlias(permataAliasAccounts.get(i).getIdAlias());
//            permataAliasAccountDB2.setUserId(permataAliasAccounts.get(i).getUserId());
//            permataAliasAccountDB2.setCustRefId(permataAliasAccounts.get(i).getCustRefId());
//            permataAliasAccountDB2.setCategoryAlias(permataAliasAccounts.get(i).getCategoryAlias());
//            permataAliasAccountDB2.setAccountNumber(permataAliasAccounts.get(i).getAccountNumber());
//            permataAliasAccountDB2.setAliasNumber(permataAliasAccounts.get(i).getAliasNumber());
//            permataAliasAccountDB2.setUpdatedBy(permataAliasAccounts.get(i).getUpdatedBy());
//            permataAliasAccountDB2.setUpdatedTimestamp(permataAliasAccounts.get(i).getUpdatedTimestamp());
//            permataAliasAccountDB2.setIsMigrate("Y");
//            permataAliasAccountDB2.setCreatedBy(permataAliasAccounts.get(i).getCreatedBy());

//            permataAliasAccountDB2.setCreatedTimestamp(permataAliasAccounts.get(i).getCreatedTimestamp());

//
//            permataAliasAccountListDB2.add(permataAliasAccountDB2);
            // CustRefID
            if (custRefId == "") {
                custRefId = "'" + custRefId + permataAliasAccounts.get(i).getGcn() + "'" + ",";
            }
            if (i == permataAliasAccounts.size() - 1) {
                custRefId = custRefId + "'" + permataAliasAccounts.get(i).getGcn() + "'";
            } else {
                custRefId = custRefId + "'" + permataAliasAccounts.get(i).getGcn() + "'" + ",";
            }

            //CategoryAlias
            if (categoryAlias == "") {
                categoryAlias = "'" + categoryAlias + permataAliasAccounts.get(i).getCategoryAlias() + "'" + ",";
            }
            if (i == permataAliasAccounts.size() - 1) {
                categoryAlias = categoryAlias + "'" + permataAliasAccounts.get(i).getCategoryAlias() + "'";
            } else {
                categoryAlias = categoryAlias + "'" + permataAliasAccounts.get(i).getCategoryAlias() + "'" + ",";
            }

            //AccountNumber
            if (accountNumber == "") {
                accountNumber = "'" + accountNumber + permataAliasAccounts.get(i).getAccountNumber() + "'" + ",";
            }
            if (i == permataAliasAccounts.size() - 1) {
                accountNumber = accountNumber + "'" + permataAliasAccounts.get(i).getAccountNumber() + "'";
            } else {
                accountNumber = accountNumber + "'" + permataAliasAccounts.get(i).getAccountNumber() + "'" + ",";
            }


        }
        Timestamp timestampStart = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Save Start at : " + timestampStart);
//        db1PermataAliasAccountRepository.UpdateStatus3();
        System.out.println("save MySql - Data = " + permataAliasAccountListMySql.size());
        mySqlPermataAliasAccountRepository.saveAll(permataAliasAccountListMySql);

        System.out.println("Update DB2");
        updateAlias.update(custRefId, categoryAlias, accountNumber);


        Timestamp timestampDone = new java.sql.Timestamp((new Date().getTime()));
        System.out.println("Done Start at : " + timestampDone);

        conterSavedRecord = conterSavedRecord + permataAliasAccountListMySql.size();
        System.out.println("\nSaved Data :" + conterSavedRecord);
        System.out.println("====================");
    }


    public void inpuDataPermataAliasAccount() {
        List<com.permata.migrate.entity.db2.PermataAliasAccount> ListPermataAliasAccountDB2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            com.permata.migrate.entity.db2.PermataAliasAccount permataAliasAccount = new com.permata.migrate.entity.db2.PermataAliasAccount();
//            permataAliasAccount.setIdAlias(i);
            permataAliasAccount.setAccountNumber("test" + i);
            permataAliasAccount.setAliasNumber("test");
            permataAliasAccount.setCategoryAlias("test" + i);
//            permataAliasAccount.setc("rosi");
//            permataAliasAccount.setCreatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
            permataAliasAccount.setGcn("cri" + i);
            permataAliasAccount.setUpdatedBy("rosi");
            permataAliasAccount.setUpdatedTimestamp(Timestamp.valueOf("2019-10-22 23:27:18"));
//            permataAliasAccount.setUserId("testing" + i);
            permataAliasAccount.setStatus(null);

            ListPermataAliasAccountDB2.add(permataAliasAccount);

        }
        db2PermataAliasAccountRepository.saveAll(ListPermataAliasAccountDB2);
    }
}
