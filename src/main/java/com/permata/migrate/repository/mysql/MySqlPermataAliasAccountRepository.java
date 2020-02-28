package com.permata.migrate.repository.mysql;

import com.permata.migrate.entity.mysql.PermataAliasAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HP on 09/10/2019.
 */
public interface MySqlPermataAliasAccountRepository extends JpaRepository<PermataAliasAccount, Long> {


}
