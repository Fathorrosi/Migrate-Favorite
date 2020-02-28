package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.ImgIdGenerator;
import com.permata.migrate.entity.db2.PermataFavorite;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2ImgIdGeneratorService {

    public abstract List<ImgIdGenerator> getAllImgIdGenerator();

}
