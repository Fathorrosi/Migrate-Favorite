package com.permata.migrate.repository.db2;

import com.permata.migrate.entity.db2.PermataFavorite;
import com.permata.migrate.service.PermataAliasAccountService;
import com.permata.migrate.service.PermataFavoriteService;
import com.permata.migrate.ui.ConsoleView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2PermataFavoriteRepository extends JpaRepository<PermataFavorite, Long> {

    @Query(value = "SELECT * FROM PERMATA_FAVORITE_SIMULATE where (STATUS is NULL OR STATUS = '') ORDER BY id_fav ASC FETCH FIRST 10000 ROWS ONLY ", nativeQuery = true)
    List<PermataFavorite> getPermataFavorite(@Param("RequestData") int RequestData);

    @Query(value = "SELECT count(*) FROM PERMATA_FAVORITE_SIMULATE where (STATUS is NULL OR STATUS = '') ", nativeQuery = true)
    int countPermataFavoriteNotDuplicate();

    @Query(value = "SELECT * FROM PERMATA_FAVORITE_SIMULATE where ID_FAV = 1", nativeQuery = true)
    PermataFavorite getPermataFavorite();

    @Query(value = "select * from PERMATA_FAVORITE_SIMULATE \n" +
            "where CIF in (select CIF from PERMATA_FAVORITE_SIMULATE  \n" +
            "GROUP BY CIF having count(*)>1) and (STATUS is NULL OR STATUS = '') ORDER BY CIF ASC FETCH FIRST 10000  ROWS ONLY ", nativeQuery = true)
    List<PermataFavorite> getPermataFavoriteduplicate(@Param("RequestData") int RequestData);

    @Query(value = "SELECT COUNT (*) FROM PERMATA_FAVORITE_SIMULATE where (STATUS is NULL OR STATUS = '') ", nativeQuery = true)
    int countAllData();

    @Query(value = "select count(*) from PERMATA_FAVORITE_SIMULATE \n" +
            "where CIF in (select CIF from PERMATA_FAVORITE_SIMULATE  \n" +
            "GROUP BY CIF having count(*)>1) and (STATUS is NULL OR STATUS = '')  ", nativeQuery = true)
    int countRecordWithDuplicateCustRefId();

    @Query(value = "SELECT * FROM PERMATA_FAVORITE_SIMULATE where (STATUS is NULL OR STATUS = '')  and CIF=:CIF ORDER BY id_fav ASC     ", nativeQuery = true)
    List<PermataFavorite> getPermataFavoriteBycustRefId(@Param("CIF") String CIF);


}
