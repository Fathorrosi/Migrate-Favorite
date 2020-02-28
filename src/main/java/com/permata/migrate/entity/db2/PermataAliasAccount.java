package com.permata.migrate.entity.db2;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HP on 04/11/2019.
 */
@Entity
@Table(name = "PERMATA_ALIAS_ACCOUNT", schema = "SONEDBA", catalog = "")
@IdClass(PermataAliasAccountPK.class)
public class PermataAliasAccount {
    private String userId;
    private String gcn;
    private String categoryAlias;
    private String accountNumber;
    private String aliasNumber;
    private String updatedBy;
    private Timestamp updatedTimestamp;
    private String status;

    @Id
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 100)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "GCN", nullable = false, insertable = true, updatable = true, length = 50)
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Id
    @Column(name = "CATEGORY_ALIAS", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    @Id
    @Column(name = "ACCOUNT_NUMBER", nullable = false, insertable = true, updatable = true, length = 25)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "ALIAS_NUMBER", nullable = false, insertable = true, updatable = true, length = 50)
    public String getAliasNumber() {
        return aliasNumber;
    }

    public void setAliasNumber(String aliasNumber) {
        this.aliasNumber = aliasNumber;
    }

    @Basic
    @Column(name = "UPDATED_BY", nullable = true, insertable = true, updatable = true, length = 255)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "UPDATED_TIMESTAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermataAliasAccount that = (PermataAliasAccount) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
        if (categoryAlias != null ? !categoryAlias.equals(that.categoryAlias) : that.categoryAlias != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (aliasNumber != null ? !aliasNumber.equals(that.aliasNumber) : that.aliasNumber != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (updatedTimestamp != null ? !updatedTimestamp.equals(that.updatedTimestamp) : that.updatedTimestamp != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (gcn != null ? gcn.hashCode() : 0);
        result = 31 * result + (categoryAlias != null ? categoryAlias.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (aliasNumber != null ? aliasNumber.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}


//@Entity
//@Table(name = "PERMATA_ALIAS_ACCOUNT", schema = "SONEDBA", catalog = "")
//@IdClass(PermataAliasAccountPK.class)
//public class PermataAliasAccount {
//    private long idAlias;
//    private String userId;
//    private String gcn;
//    private String categoryAlias;
//    private String accountNumber;
//    private String aliasNumber;
//    private String createdBy;
//    private Timestamp createdTimestamp;
//    private String updatedBy;
//    private Timestamp updatedTimestamp;
//    private String status;
//
//    @Basic
//    @Column(name = "ID_ALIAS")
//    public long getIdAlias() {
//        return idAlias;
//    }
//
//    public void setIdAlias(long idAlias) {
//        this.idAlias = idAlias;
//    }
//
//    @Id
//    @Column(name = "USER_ID")
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    @Id
//    @Column(name = "GCN")
//    public String getGcn() {
//        return gcn;
//    }
//
//    public void setGcn(String gcn) {
//        this.gcn = gcn;
//    }
//
//    @Id
//    @Column(name = "CATEGORY_ALIAS")
//    public String getCategoryAlias() {
//        return categoryAlias;
//    }
//
//    public void setCategoryAlias(String categoryAlias) {
//        this.categoryAlias = categoryAlias;
//    }
//
//    @Id
//    @Column(name = "ACCOUNT_NUMBER")
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    @Basic
//    @Column(name = "ALIAS_NUMBER")
//    public String getAliasNumber() {
//        return aliasNumber;
//    }
//
//    public void setAliasNumber(String aliasNumber) {
//        this.aliasNumber = aliasNumber;
//    }
//
//    @Basic
//    @Column(name = "CREATED_BY")
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Basic
//    @Column(name = "CREATED_TIMESTAMP")
//    public Timestamp getCreatedTimestamp() {
//        return createdTimestamp;
//    }
//
//    public void setCreatedTimestamp(Timestamp createdTimestamp) {
//        this.createdTimestamp = createdTimestamp;
//    }
//
//    @Basic
//    @Column(name = "UPDATED_BY")
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    @Basic
//    @Column(name = "UPDATED_TIMESTAMP")
//    public Timestamp getUpdatedTimestamp() {
//        return updatedTimestamp;
//    }
//
//    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
//        this.updatedTimestamp = updatedTimestamp;
//    }
//
//
//    @Basic
//    @Column(name = "STATUS")
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PermataAliasAccount that = (PermataAliasAccount) o;
//
//        if (idAlias != that.idAlias) return false;
//        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
//        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
//        if (categoryAlias != null ? !categoryAlias.equals(that.categoryAlias) : that.categoryAlias != null)
//            return false;
//        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
//            return false;
//        if (aliasNumber != null ? !aliasNumber.equals(that.aliasNumber) : that.aliasNumber != null) return false;
//        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
//        if (createdTimestamp != null ? !createdTimestamp.equals(that.createdTimestamp) : that.createdTimestamp != null)
//            return false;
//        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
//        if (updatedTimestamp != null ? !updatedTimestamp.equals(that.updatedTimestamp) : that.updatedTimestamp != null)
//            return false;
//        if (status != null ? !status.equals(that.status) : that.status != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idAlias ^ (idAlias >>> 32));
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
//        result = 31 * result + (gcn != null ? gcn.hashCode() : 0);
//        result = 31 * result + (categoryAlias != null ? categoryAlias.hashCode() : 0);
//        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
//        result = 31 * result + (aliasNumber != null ? aliasNumber.hashCode() : 0);
//        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
//        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
//        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
//        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
//        result = 31 * result + (status != null ? status.hashCode() : 0);
//        return result;
//    }
//}
