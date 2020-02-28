package com.permata.migrate.service.mysql;

import com.permata.migrate.entity.mysql.PermataFavorite;

import java.util.List;

public interface MySqlPermataFavoriteService {
    public abstract List<PermataFavorite> getAllPermataFavorite();
    public abstract PermataFavorite savePermataFavorite(PermataFavorite permataFavorite);
//    public abstract PermataFavorite saveAllPermataFavorite(Perma permataFavorite);


}
