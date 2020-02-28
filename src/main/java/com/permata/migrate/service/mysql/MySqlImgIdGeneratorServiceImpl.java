package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.ImgIdGenerator;
import com.permata.migrate.repository.mysql.MySqlImgIdGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
@Service
public class MySqlImgIdGeneratorServiceImpl implements MySqlImgIdGeneratorService {

    @Autowired
    private MySqlImgIdGeneratorRepository mySqlImgIdGeneratorRepository;


    @Override
    public List<ImgIdGenerator> getAllImgIdGenerator() {
        return (List<ImgIdGenerator>) mySqlImgIdGeneratorRepository.findAll();
    }

    @Override
    public ImgIdGenerator saveImgIdGenerator(ImgIdGenerator imgIdGenerator) {
        return mySqlImgIdGeneratorRepository.save(imgIdGenerator);
    }
}
