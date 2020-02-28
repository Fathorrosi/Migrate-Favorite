package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.ImgIdGenerator;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface MySqlImgIdGeneratorService {

    public abstract List<ImgIdGenerator> getAllImgIdGenerator();
    public abstract ImgIdGenerator saveImgIdGenerator(ImgIdGenerator imgIdGenerator);

}
