package com.permata.migrate.repository.mysql;

import com.permata.migrate.entity.db2.PermataFavorite;
import com.permata.migrate.entity.mysql.ImgIdGenerator;
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
@Repository
public interface MySqlImgIdGeneratorRepository extends JpaRepository<ImgIdGenerator, Long> {

    //    String a = "testing";
//
//    @Query(value = "SELECT COUNT(*) FROM IMG_ID_GENERATOR WHERE GCN =:gcn",nativeQuery = true)
//    String checkGcn(@Param("gcn") String getCountGcn);
//
//    @Query(value = "SELECT SEQUENCE FROM IMG_ID_GENERATOR WHERE GCN =:gcn",nativeQuery = true)
//    String getSequence(@Param("gcn") String getCountGcn);
//
//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO img_id_generator(gcn, sequence) \n" +
//            "\tselect gcn,  \n" +
//            "\t(SELECT count(GCN) FROM PERMATA_FAVORITE GROUP BY GCN\n" +
//            "GO",nativeQuery = true)
//    public void saveImgIdGen();
    @Transactional
    @Modifying
    @Query(value = "SELECT SEQUENCE FROM IMG_ID_GENERATOR WHERE GCN =:gcn", nativeQuery = true)
    int getSequence(@Param("gcn") String getCountGcn);
}
