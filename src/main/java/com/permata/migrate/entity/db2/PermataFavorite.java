package com.permata.migrate.entity.db2;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by HP on 10/10/2019.
 */
@Entity
@Table(name = "PERMATA_FAVORITE", schema = "SONEDBA", catalog = "")
public class PermataFavorite {
    private long idFav;
    private String transactionType;
    private String subTransactionType;
    private String gcn;
    private String destinationNumber;
    private String action;
    private String aliasName;
    private int amount;
    private String createdBy;
    private Timestamp createdTimestamp;
    private String idFavImage;
    private String imageExist;
    private byte[] imageData;
    private String institutionCode;
    private String memo;
    private String sourceAccount;
    private String updatedBy;
    private Timestamp updatedTimestamp;
    private String status;
    private String currency;

    @Id
    @Column(name = "ID_FAV")
    public long getIdFav() {
        return idFav;
    }

    public void setIdFav(long idFav) {
        this.idFav = idFav;
    }

    @Basic
    @Column(name = "TRANSACTION_TYPE")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Basic
    @Column(name = "SUB_TRANSACTION_TYPE")
    public String getSubTransactionType() {
        return subTransactionType;
    }

    public void setSubTransactionType(String subTransactionType) {
        this.subTransactionType = subTransactionType;
    }

    @Basic
    @Column(name = "GCN")
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Basic
    @Column(name = "DESTINATION_NUMBER")
    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    @Basic
    @Column(name = "ACTION")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "ALIAS_NAME")
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Basic
    @Column(name = "AMOUNT")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "CREATED_TIMESTAMP")
    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Basic
    @Column(name = "ID_FAV_IMAGE")
    public String getIdFavImage() {
        return idFavImage;
    }

    public void setIdFavImage(String idFavImage) {
        this.idFavImage = idFavImage;
    }

    @Basic
    @Column(name = "IMAGE_EXIST")
    public String getImageExist() {
        return imageExist;
    }

    public void setImageExist(String imageExist) {
        this.imageExist = imageExist;
    }

    @Basic
    @Column(name = "IMAGE_DATA")
    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Basic
    @Column(name = "INSTITUTION_CODE")
    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @Basic
    @Column(name = "MEMO")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "SOURCE_ACCOUNT")
    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    @Basic
    @Column(name = "UPDATED_BY")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "UPDATED_TIMESTAMP")
    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermataFavorite that = (PermataFavorite) o;

        if (idFav != that.idFav) return false;
        if (amount != that.amount) return false;
        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
            return false;
        if (subTransactionType != null ? !subTransactionType.equals(that.subTransactionType) : that.subTransactionType != null)
            return false;
        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
        if (destinationNumber != null ? !destinationNumber.equals(that.destinationNumber) : that.destinationNumber != null)
            return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (aliasName != null ? !aliasName.equals(that.aliasName) : that.aliasName != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdTimestamp != null ? !createdTimestamp.equals(that.createdTimestamp) : that.createdTimestamp != null)
            return false;
        if (idFavImage != null ? !idFavImage.equals(that.idFavImage) : that.idFavImage != null) return false;
        if (imageExist != null ? !imageExist.equals(that.imageExist) : that.imageExist != null) return false;
        if (!Arrays.equals(imageData, that.imageData)) return false;
        if (institutionCode != null ? !institutionCode.equals(that.institutionCode) : that.institutionCode != null)
            return false;
        if (memo != null ? !memo.equals(that.memo) : that.memo != null) return false;
        if (sourceAccount != null ? !sourceAccount.equals(that.sourceAccount) : that.sourceAccount != null)
            return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (updatedTimestamp != null ? !updatedTimestamp.equals(that.updatedTimestamp) : that.updatedTimestamp != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idFav ^ (idFav >>> 32));
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (subTransactionType != null ? subTransactionType.hashCode() : 0);
        result = 31 * result + (gcn != null ? gcn.hashCode() : 0);
        result = 31 * result + (destinationNumber != null ? destinationNumber.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (aliasName != null ? aliasName.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
        result = 31 * result + (idFavImage != null ? idFavImage.hashCode() : 0);
        result = 31 * result + (imageExist != null ? imageExist.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(imageData);
        result = 31 * result + (institutionCode != null ? institutionCode.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (sourceAccount != null ? sourceAccount.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
