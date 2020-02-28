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

    @Query(value = "SELECT * FROM SONEDBA.permata_alias_account",nativeQuery = true)
    List<PermataAliasAccount> getAllPermataAliasAccount();

    @Query(value = "SELECT * FROM SONEDBA.permata_alias_account where STATUS is NULL order BY GCN asc FETCH FIRST 10000 ROWS ONLY ",nativeQuery = true)
    List<PermataAliasAccount> getPermataAliasAccount(@Param("RequestData") int RequestData);

    @Transactional
    @Modifying
    @Query(value = "UPDATE SONEDBA.permata_alias_account SET STATUS='Done' where STATUS='Process'",nativeQuery = true)
    void UpdateStatus3();

    @Transactional
    @Modifying
    @Query(value = "UPDATE SONEDBA.permata_alias_account SET STATUS='Process' where STATUS='Ready' FETCH FIRST :RequestData ROWS ONLY ",nativeQuery = true)
    void UpdateStatus2(@Param("RequestData") int RequestData);

    @Query(value = "SELECT COUNT (*) FROM SONEDBA.permata_alias_account where STATUS is NULL",nativeQuery = true)
    int countAllData();
}
