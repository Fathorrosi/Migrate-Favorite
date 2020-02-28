package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.PermataAliasAccount;
import com.permata.migrate.repository.db2.DB2PermataAliasAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
@Service
public class DB2PermataAliasAccountServiceImpl implements DB2PermataAliasAccountService {

    @Autowired
    private DB2PermataAliasAccountRepository db2PermataAliasAccountRepository;




    @Override
    public List<PermataAliasAccount> getAllPermataAliasAccount(int data) {
        return db2PermataAliasAccountRepository.getPermataAliasAccount(data);
    }
}
