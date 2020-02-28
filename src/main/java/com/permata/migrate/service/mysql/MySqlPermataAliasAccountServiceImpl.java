package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.PermataAliasAccount;
import com.permata.migrate.repository.mysql.MySqlPermataAliasAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
@Service
public class MySqlPermataAliasAccountServiceImpl implements MySqlPermataAliasAccountService {

    @Autowired
    private MySqlPermataAliasAccountRepository mySqlPermataAliasAccountRepository;


    @Override
    public List<PermataAliasAccount> getAllPermataAliasAccount() {
        return (List<PermataAliasAccount>) mySqlPermataAliasAccountRepository.findAll();
    }

    @Override
    public PermataAliasAccount savePermataAliasAccount(PermataAliasAccount permataAliasAccount) {
        return mySqlPermataAliasAccountRepository.save(permataAliasAccount);
    }
}
