// 
// Decompiled by Procyon v0.5.36
// 

package com.permata.migrate.entity.mysql2;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Blob;

@Table(name = "fav_image")
@Entity
@Transactional
public class Image extends Auditor<String>
{
    @Id
    @Column(name = "id_image", length = 255 )
    public String idImage;
    @Basic
    @Column(name = "id_fav")
    public Long idFav;
    @Basic
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB", nullable = true)
    public Blob image;
    
    public String getIdImage() {
        return this.idImage;
    }
    
    public void setIdImage(final String idImage) {
        this.idImage = idImage;
    }
    
    public Long getIdFav() {
        return this.idFav;
    }
    
    public void setIdFav(final Long idFav) {
        this.idFav = idFav;
    }
    
    public Blob getImage() {
        return this.image;
    }
    
    public void setImage(final Blob image) {
        this.image = image;
    }
}
