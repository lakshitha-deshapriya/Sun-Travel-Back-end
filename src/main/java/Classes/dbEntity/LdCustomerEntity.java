package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_CUSTOMER", schema = "SYSTEM", catalog = "")
public class LdCustomerEntity {
    private long customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private LdAddressEntity ldAddressByAddressId;

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_CUSTOMER_CUSTOMER_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_CUSTOMER_CUSTOMER_ID_SEQ", allocationSize = 1, name = "LD_CUSTOMER_CUSTOMER_ID_SEQ")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "CUSTOMER_NAME")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdCustomerEntity that = (LdCustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public LdAddressEntity getLdAddressByAddressId() {
        return ldAddressByAddressId;
    }

    public void setLdAddressByAddressId(LdAddressEntity ldAddressByAddressId) {
        this.ldAddressByAddressId = ldAddressByAddressId;
    }
}
