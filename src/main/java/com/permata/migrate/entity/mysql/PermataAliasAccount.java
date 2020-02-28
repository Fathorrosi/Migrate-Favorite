package com.permata.migrate.entity.mysql;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by HP on 04/11/2019.
 */
@Entity
@Table(name = "permata_alias_account")
@IdClass(PermataAliasAccountPK.class)
public class PermataAliasAccount {
    private String gcn;
    private String categoryAlias;
    private String accountNumber;
    private String aliasName;
    private String createdBy;
    private Timestamp createdTimestamp;
    private String updatedBy;
    private Timestamp updatedTimestamp;

    @Id
    @Column(name = "gcn", nullable = false, insertable = true, updatable = true, length = 50)
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Id
    @Column(name = "category_alias", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    @Id
    @Column(name = "account_number", nullable = false, insertable = true, updatable = true, length = 25)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "alias_name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Basic
    @Column(name = "created_by", nullable = false, insertable = true, updatable = true, length = 255)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_timestamp", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Basic
    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "updated_timestamp", nullable = true, insertable = true, updatable = true)
    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermataAliasAccount that = (PermataAliasAccount) o;

        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
        if (categoryAlias != null ? !categoryAlias.equals(that.categoryAlias) : that.categoryAlias != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (aliasName != null ? !aliasName.equals(that.aliasName) : that.aliasName != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdTimestamp != null ? !createdTimestamp.equals(that.createdTimestamp) : that.createdTimestamp != null)
            return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (updatedTimestamp != null ? !updatedTimestamp.equals(that.updatedTimestamp) : that.updatedTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gcn != null ? gcn.hashCode() : 0;
        result = 31 * result + (categoryAlias != null ? categoryAlias.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (aliasName != null ? aliasName.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
        return result;
    }
}
