package com.permata.migrate.repository.db2;

import com.permata.migrate.entity.db2.PermataFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2PermataFavoriteRepository extends JpaRepository<PermataFavorite, Long> {


    @Query(value = "SELECT * FROM SONEDBA.PERMATA_FAVORITE where STATUS is NULL ORDER BY id_fav ASC FETCH FIRST 10000 ROWS ONLY ", nativeQuery = true)
    List<PermataFavorite> getPermataFavorite(@Param("RequestData") int RequestData);

    @Query(value = "select * from SONEDBA.permata_favorite \n" +
            "where gcn in (select gcn from SONEDBA.PERMATA_FAVORITE  \n" +
            "GROUP BY GCN having count(*)>1) and STATUS is NULL ORDER BY GCN ASC FETCH FIRST 10000 ROWS ONLY   ", nativeQuery = true)
    List<PermataFavorite> getPermataFavoriteduplicate(@Param("RequestData") int RequestData);

    @Query(value = "SELECT COUNT (*) FROM SONEDBA.PERMATA_FAVORITE where STATUS is NULL", nativeQuery = true)
    int countAllData();

    @Query(value = "select count(*) from SONEDBA.permata_favorite \n" +
            "where gcn in (select gcn from SONEDBA.PERMATA_FAVORITE  \n" +
            "GROUP BY GCN having count(*)>1) and STATUS is NULL ", nativeQuery = true)
    int countRecordWithDuplicateGcn();


//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE SONEDBA.PERMATA_FAVORITE SET STATUS='NULL' where STATUS<>'Done' FETCH FIRST :RequestData ROWS ONLY ", nativeQuery = true)
//    void UpdateStatus2(@Param("RequestData") int RequestData);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE SONEDBA.PERMATA_FAVORITE SET STATUS='Done' where STATUS<>'Done'", nativeQuery = true)
//    void UpdateStatus3();

//    @Query(value = "select * from permata_favorite \n" +
//            "where gcn in (select gcn from PERMATA_FAVORITE  \n" +
//            "GROUP BY GCN having count(*)>1) and STATUS='NULL' ORDER BY GCN DESC FETCH FIRST 1000000 ROWS ONLY",nativeQuery = true)
//    List<PermataFavorite> getPermataFavoriteduplicate2();

//    @Query(value = "select gcn FROM SONEDBA.PERMATA_FAVORITE group by gcn having count(1)>1", nativeQuery = true)
//    List<String> getDuplicatGcn();
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE SONEDBA.PERMATA_FAVORITE SET ID_FAV_IMAGE=:idFavImg2 WHERE  ID_FAV_IMAGE =:idFavImg1", nativeQuery = true)
//    void updateDBSource(@Param("idFavImg1") String idFavImg, @Param("idFavImg2") String idFavImg2);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE SONEDBA.PERMATA_FAVORITE SET STATUS='Migrated' WHERE  GCN =:gcn", nativeQuery = true)
//    void updateDBSourceStatus(@Param("gcn") String gcn);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE SONEDBA.PERMATA_FAVORITE SET ID_FAV_IMAGE=:gcn WHERE  GCN =:gcn", nativeQuery = true)
//    void updateIdFavImg(@Param("gcn") String idFavImg);


    @Query(value = "SELECT * FROM SONEDBA.PERMATA_FAVORITE where STATUS is NULL and gcn=:gcn ORDER BY id_fav ASC     ", nativeQuery = true)
    List<PermataFavorite> getPermataFavoriteByGcn(@Param("gcn") String gcn);

}
