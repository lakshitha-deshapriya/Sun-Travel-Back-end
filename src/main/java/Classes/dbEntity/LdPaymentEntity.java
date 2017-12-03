package Classes.dbEntity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "LD_PAYMENT", schema = "SYSTEM", catalog = "")
public class LdPaymentEntity {
    private long paymentId;
    private Double amount;
    private Time paymentDate;
    private LdAccommodationEntity ldAccommodationByAccommodationId;

    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_PAYMENT_PAYMENT_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_PAYMENT_PAYMENT_ID_SEQ", allocationSize = 1, name = "LD_PAYMENT_PAYMENT_ID_SEQ")
    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "AMOUNT")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "PAYMENT_DATE")
    public Time getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Time paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdPaymentEntity that = (LdPaymentEntity) o;

        if (paymentId != that.paymentId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (paymentId ^ (paymentId >>> 32));
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOMMODATION_ID", referencedColumnName = "ACCOMMODATION_ID", nullable = false)
    public LdAccommodationEntity getLdAccommodationByAccommodationId() {
        return ldAccommodationByAccommodationId;
    }

    public void setLdAccommodationByAccommodationId(LdAccommodationEntity ldAccommodationByAccommodationId) {
        this.ldAccommodationByAccommodationId = ldAccommodationByAccommodationId;
    }
}
