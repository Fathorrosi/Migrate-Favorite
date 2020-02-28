package com.permata.migrate.entity.mysql;

import org.hibernate.dialect.MySQL8Dialect;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by HP on 10/10/2019.
 */
@Entity
@javax.persistence.Table(name = "permata_favorite")
@IdClass(PermataFavoritePK.class)
public class PermataFavorite {
    private String transactionType;
    private String subTransactionType;
    private String gcn;
    private String destinationNumber;
    private String action;
    private String aliasName;
    private BigDecimal amount;
    private String createdBy;
    private Timestamp createdTimestamp;
    private long idFav;
    private String idFavImage;
    private String imageExist;
    private String institutionCode;
    private String memo;
    private String sourceAccount;
    private String updatedBy;
    private Timestamp updatedTimestamp;
    private String currency;

    @Id
    @Column(name = "transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Id
    @Column(name = "sub_transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    public String getSubTransactionType() {
        return subTransactionType;
    }

    public void setSubTransactionType(String subTransactionType) {
        this.subTransactionType = subTransactionType;
    }

    @Id
    @Column(name = "gcn", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Id
    @Column(name = "destination_number", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    @Basic
    @Column(name = "action", nullable = true, insertable = true, updatable = true, length = 50)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Id
    @Column(name = "alias_name", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    @Column(name = "id_fav", unique = true , nullable = false, insertable = true, updatable = true, columnDefinition = "serial")
    public long getIdFav() {
        return idFav;
    }

    public void setIdFav(long idFav) {
        this.idFav = idFav;
    }

    @Basic
    @Column(name = "id_fav_image", nullable = true, insertable = true, updatable = true, length = 255)
    public String getIdFavImage() {
        return idFavImage;
    }

    public void setIdFavImage(String idFavImage) {
        this.idFavImage = idFavImage;
    }

    @Basic
    @Column(name = "image_exist", nullable = false, insertable = true, updatable = true, length = 1)
    public String getImageExist() {
        return imageExist;
    }

    public void setImageExist(String imageExist) {
        this.imageExist = imageExist;
    }

    @Basic
    @Column(name = "institution_code", nullable = false, insertable = true, updatable = true, length = 60)
    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @Basic
    @Column(name = "memo", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "source_account", nullable = true, insertable = true, updatable = true, length = 30)
    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
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

    @Basic
    @Column(name = "currency", nullable = false, insertable = true, updatable = true, length = 30)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PermataFavorite that = (PermataFavorite) o;
//
//        if (idFav != that.idFav) return false;
//        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
//            return false;
//        if (subTransactionType != null ? !subTransactionType.equals(that.subTransactionType) : that.subTransactionType != null)
//            return false;
//        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
//        if (destinationNumber != null ? !destinationNumber.equals(that.destinationNumber) : that.destinationNumber != null)
//            return false;
//        if (action != null ? !action.equals(that.action) : that.action != null) return false;
//        if (aliasName != null ? !aliasName.equals(that.aliasName) : that.aliasName != null) return false;
//        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
//        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
//        if (createdTimestamp != null ? !createdTimestamp.equals(that.createdTimestamp) : that.createdTimestamp != null)
//            return false;
//        if (idFavImage != null ? !idFavImage.equals(that.idFavImage) : that.idFavImage != null) return false;
//        if (imageExist != null ? !imageExist.equals(that.imageExist) : that.imageExist != null) return false;
//        if (institutionCode != null ? !institutionCode.equals(that.institutionCode) : that.institutionCode != null)
//            return false;
//        if (memo != null ? !memo.equals(that.memo) : that.memo != null) return false;
//        if (sourceAccount != null ? !sourceAccount.equals(that.sourceAccount) : that.sourceAccount != null)
//            return false;
//        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
//        if (updatedTimestamp != null ? !updatedTimestamp.equals(that.updatedTimestamp) : that.updatedTimestamp != null)
//            return false;
//        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = transactionType != null ? transactionType.hashCode() : 0;
//        result = 31 * result + (subTransactionType != null ? subTransactionType.hashCode() : 0);
//        result = 31 * result + (gcn != null ? gcn.hashCode() : 0);
//        result = 31 * result + (destinationNumber != null ? destinationNumber.hashCode() : 0);
//        result = 31 * result + (action != null ? action.hashCode() : 0);
//        result = 31 * result + (aliasName != null ? aliasName.hashCode() : 0);
//        result = 31 * result + (amount != null ? amount.hashCode() : 0);
//        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
//        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
//        result = 31 * result + (int) (idFav ^ (idFav >>> 32));
//        result = 31 * result + (idFavImage != null ? idFavImage.hashCode() : 0);
//        result = 31 * result + (imageExist != null ? imageExist.hashCode() : 0);
//        result = 31 * result + (institutionCode != null ? institutionCode.hashCode() : 0);
//        result = 31 * result + (memo != null ? memo.hashCode() : 0);
//        result = 31 * result + (sourceAccount != null ? sourceAccount.hashCode() : 0);
//        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
//        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
//        result = 31 * result + (currency != null ? currency.hashCode() : 0);
//        return result;
//    }
}
