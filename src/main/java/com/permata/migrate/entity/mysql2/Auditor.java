// 
// Decompiled by Procyon v0.5.36
// 

package com.permata.migrate.entity.mysql2;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
abstract class Auditor<U>
{
    @CreatedBy
    protected U created_by;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created_date;
    @LastModifiedBy
    protected U last_modified_by;
    @org.springframework.data.annotation.LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date last_modified_date;
    
    public U getCreated_by() {
        return (U)this.created_by;
    }
    
    public void setCreated_by(final U created_by) {
        this.created_by = created_by;
    }
    
    public Date getCreated_date() {
        return this.created_date;
    }
    
    public void setCreated_date(final Date created_date) {
        this.created_date = created_date;
    }
    
    public U getLast_modified_by() {
        return (U)this.last_modified_by;
    }
    
    public void setLast_modified_by(final U last_modified_by) {
        this.last_modified_by = last_modified_by;
    }
    
    public Date getLast_modified_date() {
        return this.last_modified_date;
    }
    
    public void setLast_modified_date(final Date last_modified_date) {
        this.last_modified_date = (Date) last_modified_date;
    }
}
