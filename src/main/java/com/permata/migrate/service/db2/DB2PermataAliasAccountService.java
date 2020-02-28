package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.PermataAliasAccount;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2PermataAliasAccountService {

    public abstract List<PermataAliasAccount> getAllPermataAliasAccount(int data);

}
