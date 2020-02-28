package com.permata.migrate.repository.db2;

import com.permata.migrate.entity.db2.ImgIdGenerator;
import com.permata.migrate.entity.db2.PermataFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2ImgIdGeneratorRepository extends JpaRepository<ImgIdGenerator, Long> {



}
