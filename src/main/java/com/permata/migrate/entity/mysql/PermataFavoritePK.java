package com.permata.migrate.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by HP on 04/02/2020.
 */
public class PermataFavoritePK implements Serializable {
    private String transactionType;

    @Column(name = "transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    @Id
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    private String subTransactionType;

    @Column(name = "sub_transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    @Id
    public String getSubTransactionType() {
        return subTransactionType;
    }

    public void setSubTransactionType(String subTransactionType) {
        this.subTransactionType = subTransactionType;
    }

    private String gcn;

    @Column(name = "gcn", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    @Id
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    private String destinationNumber;

    @Column(name = "destination_number", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    @Id
    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    private String aliasName;

    @Column(name = "alias_name", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
    @Id
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PermataFavoritePK that = (PermataFavoritePK) o;
//
//        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
//            return false;
//        if (subTransactionType != null ? !subTransactionType.equals(that.subTransactionType) : that.subTransactionType != null)
//            return false;
//        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
//        if (destinationNumber != null ? !destinationNumber.equals(that.destinationNumber) : that.destinationNumber != null)
//            return false;
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
//        return result;
//    }
}
