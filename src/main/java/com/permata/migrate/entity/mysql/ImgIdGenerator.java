package com.permata.migrate.entity.mysql;

import javax.persistence.*;

/**
 * Created by HP on 14/10/2019.
 */
@Entity
@Table(name = "img_id_generator")
public class ImgIdGenerator {
    private String custRefId;
    private Integer sequence;

    @Id
    @Column(name = "cust_ref_id", nullable = false, insertable = true, updatable = true, length = 100)
    public String getCustRefId() {
        return custRefId;
    }

    public void setCustRefId(String custRefId) {
        this.custRefId = custRefId;
    }

    @Basic
    @Column(name = "sequence", nullable = true, insertable = true, updatable = true)
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImgIdGenerator that = (ImgIdGenerator) o;

        if (custRefId != null ? !custRefId.equals(that.custRefId) : that.custRefId != null) return false;
        if (sequence != null ? !sequence.equals(that.sequence) : that.sequence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custRefId != null ? custRefId.hashCode() : 0;
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        return result;
    }
}
