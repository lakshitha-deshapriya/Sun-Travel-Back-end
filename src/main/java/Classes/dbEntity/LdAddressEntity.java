package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_ADDRESS", schema = "SYSTEM", catalog = "")
public class LdAddressEntity {
    private long addressId;
    private String postBoxNo;
    private String region;
    private Long zipcode;
    private LdCityEntity ldCityByCityId;

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_ADDRESS_ADDRESS_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_ADDRESS_ADDRESS_ID_SEQ", allocationSize = 1, name = "LD_ADDRESS_ADDRESS_ID_SEQ")
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "POST_BOX_NO")
    public String getPostBoxNo() {
        return postBoxNo;
    }

    public void setPostBoxNo(String postBoxNo) {
        this.postBoxNo = postBoxNo;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "ZIPCODE")
    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdAddressEntity that = (LdAddressEntity) o;

        if (addressId != that.addressId) return false;
        if (postBoxNo != null ? !postBoxNo.equals(that.postBoxNo) : that.postBoxNo != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (postBoxNo != null ? postBoxNo.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", nullable = false)
    public LdCityEntity getLdCityByCityId() {
        return ldCityByCityId;
    }

    public void setLdCityByCityId(LdCityEntity ldCityByCityId) {
        this.ldCityByCityId = ldCityByCityId;
    }
}
