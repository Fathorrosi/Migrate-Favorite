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

    @Transactional
    @Modifying
    @Query(value = "SELECT SEQUENCE FROM IMG_ID_GENERATOR WHERE cust_ref_id =:cust_ref_id", nativeQuery = true)
    int getSequence(@Param("cust_ref_id") String getCountcust_ref_id);
}
