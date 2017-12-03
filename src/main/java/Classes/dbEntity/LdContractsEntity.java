package Classes.dbEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "LD_CONTRACTS", schema = "SYSTEM", catalog = "")
public class LdContractsEntity {
    private long contractId;
    private Date startDate;
    private Date endDate;
    private LdHotelEntity ldHotelByHotelId;

    @Id
    @Column(name = "CONTRACT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_CONTRACTS_CONTRACT_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_CONTRACTS_CONTRACT_ID_SEQ", allocationSize = 1, name = "LD_CONTRACTS_CONTRACT_ID_SEQ")
    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdContractsEntity that = (LdContractsEntity) o;

        if (contractId != that.contractId) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (contractId ^ (contractId >>> 32));
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", nullable = false)
    public LdHotelEntity getLdHotelByHotelId() {
        return ldHotelByHotelId;
    }

    public void setLdHotelByHotelId(LdHotelEntity ldHotelByHotelId) {
        this.ldHotelByHotelId = ldHotelByHotelId;
    }
}
