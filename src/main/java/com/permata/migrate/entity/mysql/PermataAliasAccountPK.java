package com.permata.migrate.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by HP on 04/11/2019.
 */
public class PermataAliasAccountPK implements Serializable {
    private String custRefId;
    private String categoryAlias;
    private String accountNumber;

    @Column(name = "CUST_REF_ID", nullable = false, insertable = true, updatable = true, length = 50)
    @Id
    public String getCustRefId() {
        return custRefId;
    }

    public void setCustRefId(String custRefId) {
        this.custRefId = custRefId;
    }

    @Column(name = "category_alias", nullable = false, insertable = true, updatable = true, length = 10)
    @Id
    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    @Column(name = "account_number", nullable = false, insertable = true, updatable = true, length = 25)
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

        if (custRefId != null ? !custRefId.equals(that.custRefId) : that.custRefId != null) return false;
        if (categoryAlias != null ? !categoryAlias.equals(that.categoryAlias) : that.categoryAlias != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custRefId != null ? custRefId.hashCode() : 0;
        result = 31 * result + (categoryAlias != null ? categoryAlias.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        return result;
    }
}
