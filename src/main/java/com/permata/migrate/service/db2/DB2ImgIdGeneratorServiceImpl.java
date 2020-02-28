package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.ImgIdGenerator;
import com.permata.migrate.repository.db2.DB2ImgIdGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
@Service
public class DB2ImgIdGeneratorServiceImpl implements DB2ImgIdGeneratorService {

    @Autowired
    private DB2ImgIdGeneratorRepository db2ImgIdGeneratorRepository;


    @Override
    public List<ImgIdGenerator> getAllImgIdGenerator() {
        return (List<ImgIdGenerator>) db2ImgIdGeneratorRepository.findAll();
    }
}
