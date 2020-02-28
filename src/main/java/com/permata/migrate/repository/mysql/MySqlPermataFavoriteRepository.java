package com.permata.migrate.repository.mysql;

import com.permata.migrate.entity.mysql.PermataFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface MySqlPermataFavoriteRepository extends JpaRepository<PermataFavorite, Long> {

    @Query(value = "SELECT * FROM PERMATA_FAVORITE",nativeQuery = true)
    List<PermataFavorite> getAllPermataFavorite();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE PERMATA_FAVORITE \n" +
            "CHANGE alias_name alias_name VARCHAR(100) CHARACTER SET utf8 \n" +
            "COLLATE utf8_bin NOT NULL;",nativeQuery = true)
    void updateCollation();


}
