package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.PermataFavorite;
import com.permata.migrate.repository.mysql.MySqlPermataFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlPermataFavoriteServiceImpl implements MySqlPermataFavoriteService {

    @Autowired
    private MySqlPermataFavoriteRepository mySqlPermataFavoriteRepository;



    @Override
    public List<PermataFavorite> getAllPermataFavorite() {
        return (List<PermataFavorite>) mySqlPermataFavoriteRepository.getAllPermataFavorite();
    }

    @Override
    public PermataFavorite savePermataFavorite(PermataFavorite permataFavorite) {
        return mySqlPermataFavoriteRepository.save(permataFavorite);
    }

//    @Override
//    public List<PermataFavorite> savePermataFavorite(Iterable<PermataFavorite> permataFavorite) {
//        return db2PermataFavoriteRepository.saveAll(permataFavorite);
//    }

//    @Override
//    public PermataFavorite savePermataFavorite(PermataFavoritepermataFavorite) {
//        return db2PermataFavoriteRepository.saveAll(permataFavorite);
//    }

//    @Override
//    public PermataFavorite saveAllPermataFavorite(PermataFavorite permataFavorite) {
//        return db2PermataFavoriteRepository.saveAll(permataFavorite);
//    }


}
