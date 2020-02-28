package com.permata.migrate.service.db2;

import com.permata.migrate.entity.db2.PermataFavorite;

import java.util.List;

/**
 * Created by HP on 09/10/2019.
 */
public interface DB2PermataFavoriteService {

    public abstract List<PermataFavorite> getPermataFavorite(int data);
    public abstract List<PermataFavorite> getPermataFavoriteByGcn(String gcn);
    public abstract List<PermataFavorite> getPermataFavoriteduplicate(int data);
    public abstract PermataFavorite savePermataFavorite(PermataFavorite permataFavorite);
    public abstract List<PermataFavorite> getAllPermataFavorite();
}
