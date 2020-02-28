package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.PermataAliasAccount;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface MySqlPermataAliasAccountService {

    public abstract List<PermataAliasAccount> getAllPermataAliasAccount();
    public abstract PermataAliasAccount savePermataAliasAccount(PermataAliasAccount permataAliasAccount);
}
