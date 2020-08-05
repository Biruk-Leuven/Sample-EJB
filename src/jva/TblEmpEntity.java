package jva;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblEmp", schema = "eg1", catalog = "")
public class TblEmpEntity {
    private int eId;
    private String eName;
    private int eAge;

    @Id
    @Column(name = "eId")
    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "eName")
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "eAge")
    public int geteAge() {
        return eAge;
    }

    public void seteAge(int eAge) {
        this.eAge = eAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblEmpEntity that = (TblEmpEntity) o;
        return eId == that.eId &&
                eAge == that.eAge &&
                Objects.equals(eName, that.eName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eId, eName, eAge);
    }
}
