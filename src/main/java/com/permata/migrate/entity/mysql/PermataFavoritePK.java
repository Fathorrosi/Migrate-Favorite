package com.permata.migrate.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by HP on 04/02/2020.
 */

public class PermataFavoritePK
        implements Serializable
{

    public PermataFavoritePK()
    {
    }

    public PermataFavoritePK(String transactionType, String subTransactionType, String custRefId, String destinationNumber, String aliasName)
    {
/*  28*/        this.transactionType = transactionType;
/*  29*/        this.subTransactionType = subTransactionType;
/*  30*/        this.custRefId = custRefId;
/*  31*/        this.destinationNumber = destinationNumber;
/*  32*/        this.aliasName = aliasName;
    }

    public String getTransactionType()
    {
/*  37*/        return transactionType;
    }

    public void setTransactionType(String transactionType)
    {
/*  40*/        this.transactionType = transactionType;
    }

    public String getSubTransactionType()
    {
/*  45*/        return subTransactionType;
    }

    public void setSubTransactionType(String subTransactionType)
    {
/*  49*/        this.subTransactionType = subTransactionType;
    }

    public String getCustRefId()
    {
/*  55*/        return custRefId;
    }

    public void setCustRefId(String custRefId)
    {
/*  58*/        this.custRefId = custRefId;
    }

    public String getDestinationNumber()
    {
/*  63*/        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber)
    {
/*  66*/        this.destinationNumber = destinationNumber;
    }

    public String getAliasName()
    {
/*  70*/        return aliasName;
    }

    public void setAliasName(String aliasName)
    {
/*  73*/        this.aliasName = aliasName;
    }

    public boolean equals(Object o)
    {
/*  78*/        if(this == o)
/*  78*/            return true;
/*  79*/        if(o == null || getClass() != o.getClass())
/*  79*/            return false;
/*  80*/        PermataFavoritePK that = (PermataFavoritePK)o;
/*  81*/        return Objects.equals(transactionType, that.transactionType) && Objects.equals(subTransactionType, that.subTransactionType) && Objects.equals(custRefId, that.custRefId) && Objects.equals(destinationNumber, that.destinationNumber) && Objects.equals(aliasName, that.aliasName);
    }

    public int hashCode()
    {
/*  89*/        return Objects.hash(new Object[]{
/*  89*/            transactionType, subTransactionType, custRefId, destinationNumber, aliasName
    });
    }

    private static final long serialVersionUID = 0x9a35793ccb0d8804L;
    private String transactionType;
    private String subTransactionType;
    private String custRefId;
    private String destinationNumber;
    private String aliasName;
}

//public class PermataFavoritePK implements Serializable {
//    private String transactionType;
//
//    @Column(name = "transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
//    @Id
//    public String getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(String transactionType) {
//        this.transactionType = transactionType;
//    }
//
//    private String subTransactionType;
//
//    @Column(name = "sub_transaction_type", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
//    @Id
//    public String getSubTransactionType() {
//        return subTransactionType;
//    }
//
//    public void setSubTransactionType(String subTransactionType) {
//        this.subTransactionType = subTransactionType;
//    }
//
//    private String custRefId;
//
//    @Column(name = "CUST_REF_ID", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
//    @Id
//    public String getCustRefId() {
//        return custRefId;
//    }
//
//    public void setCustRefId(String custRefId) {
//        this.custRefId = custRefId;
//    }
//
//    private String destinationNumber;
//
//    @Column(name = "destination_number", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
//    @Id
//    public String getDestinationNumber() {
//        return destinationNumber;
//    }
//
//    public void setDestinationNumber(String destinationNumber) {
//        this.destinationNumber = destinationNumber;
//    }
//
//    private String aliasName;
//
//    @Column(name = "alias_name", nullable = false, insertable = true, updatable = true, columnDefinition="VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_bin")
//    @Id
//    public String getAliasName() {
//        return aliasName;
//    }
//
//    public void setAliasName(String aliasName) {
//        this.aliasName = aliasName;
//    }
//
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////
////        PermataFavoritePK that = (PermataFavoritePK) o;
////
////        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
////            return false;
////        if (subTransactionType != null ? !subTransactionType.equals(that.subTransactionType) : that.subTransactionType != null)
////            return false;
////        if (custRefId != null ? !custRefId.equals(that.custRefId) : that.custRefId != null) return false;
////        if (destinationNumber != null ? !destinationNumber.equals(that.destinationNumber) : that.destinationNumber != null)
////            return false;
////
////        return true;
////    }
////
////    @Override
////    public int hashCode() {
////        int result = transactionType != null ? transactionType.hashCode() : 0;
////        result = 31 * result + (subTransactionType != null ? subTransactionType.hashCode() : 0);
////        result = 31 * result + (custRefId != null ? custRefId.hashCode() : 0);
////        result = 31 * result + (destinationNumber != null ? destinationNumber.hashCode() : 0);
////        return result;
////    }
//}
