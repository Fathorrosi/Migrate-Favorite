package com.permata.migrate.entity.db2;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by HP on 04/11/2019.
 */
public class PermataAliasAccountPK implements Serializable {
    private String userId;
    private String gcn;
    private String categoryAlias;
    private String accountNumber;

    @Column(name = "USER_ID")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "GCN")
    @Id
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Column(name = "CATEGORY_ALIAS")
    @Id
    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    @Column(name = "ACCOUNT_NUMBER")
    @Id
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermataAliasAccountPK that = (PermataAliasAccountPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
        if (categoryAlias != null ? !categoryAlias.equals(that.categoryAlias) : that.categoryAlias != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (gcn != null ? gcn.hashCode() : 0);
        result = 31 * result + (categoryAlias != null ? categoryAlias.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        return result;
    }
}
