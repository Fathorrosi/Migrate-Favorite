package com.permata.migrate.entity.db2;

import javax.persistence.*;

/**
 * Created by HP on 09/10/2019.
 */
@Entity
@Table(name = "img_id_generator")
public class ImgIdGenerator {
    private String gcn;
    private Integer sequence;

    @Id
    @Column(name = "gcn", nullable = false, insertable = true, updatable = true, length = 255)
    public String getGcn() {
        return gcn;
    }

    public void setGcn(String gcn) {
        this.gcn = gcn;
    }

    @Basic
    @Column(name = "sequence", nullable = true, insertable = true, updatable = true,length = 11)
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

        if (gcn != null ? !gcn.equals(that.gcn) : that.gcn != null) return false;
        if (sequence != null ? !sequence.equals(that.sequence) : that.sequence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gcn != null ? gcn.hashCode() : 0;
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        return result;
    }
}
