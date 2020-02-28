package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.PermataFavorite;
import com.permata.migrate.repository.db2.DB2PermataFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
@Service
public class DB2PermataFavoriteServiceImpl implements DB2PermataFavoriteService {


    static int abc = 100;

    @Autowired
    private DB2PermataFavoriteRepository db2PermataFavoriteRepository;


    @Override
    public List<PermataFavorite> getPermataFavorite(int data) {
        return  db2PermataFavoriteRepository.getPermataFavorite(data);
    }

    @Override
    public List<PermataFavorite> getPermataFavoriteByGcn(String gcn) {
        return db2PermataFavoriteRepository.getPermataFavoriteByGcn(gcn);
    }

    @Override
    public List<PermataFavorite> getPermataFavoriteduplicate(int data) {
        return db2PermataFavoriteRepository.getPermataFavoriteduplicate(data);
    }

    @Override
    public PermataFavorite savePermataFavorite(PermataFavorite permataFavorite) {
        return db2PermataFavoriteRepository.save(permataFavorite);
    }

    @Override
    public List<PermataFavorite> getAllPermataFavorite() {
        return db2PermataFavoriteRepository.findAll();
    }


}
