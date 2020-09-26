package com.permata.migrate.repository.db2;

import com.permata.migrate.entity.db2.PermataAliasAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2PermataAliasAccountRepository extends JpaRepository<PermataAliasAccount, Long> {

    @Query(value = "SELECT * FROM permata_alias_account",nativeQuery = true)
    List<PermataAliasAccount> getAllPermataAliasAccount();

    @Query(value = "SELECT * FROM permata_alias_account where STATUS is NULL order BY GCN asc FETCH FIRST 10000 ROWS ONLY ",nativeQuery = true)
    List<PermataAliasAccount> getPermataAliasAccount(@Param("RequestData") int RequestData);

    @Query(value = "SELECT COUNT (*) FROM permata_alias_account where STATUS is NULL",nativeQuery = true)
    int countAllData();

    @Transactional
    @Modifying
    @Query(value = "update permata_alias_account set STATUS = 'Y' where idImage in (:listIdImg)", nativeQuery = true)
    void updateIsMigrate(@Param("listIdImg") List<String> listIdImg);
}
