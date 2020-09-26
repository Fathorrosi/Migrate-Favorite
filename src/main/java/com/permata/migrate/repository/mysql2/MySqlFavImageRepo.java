package com.permata.migrate.repository.mysql2;

import com.permata.migrate.entity.mysql2.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlFavImageRepo extends JpaRepository<Image, Long> {
}
