package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_CITY", schema = "SYSTEM", catalog = "")
public class LdCityEntity {
    private long cityId;
    private String cityName;
    private LdCountryEntity ldCountryByCountryId;

    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_CITY_CITY_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_CITY_CITY_ID_SEQ", allocationSize = 1, name = "LD_CITY_CITY_ID_SEQ")
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CITY_NAME")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdCityEntity that = (LdCityEntity) o;

        if (cityId != that.cityId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    public LdCountryEntity getLdCountryByCountryId() {
        return ldCountryByCountryId;
    }

    public void setLdCountryByCountryId(LdCountryEntity ldCountryByCountryId) {
        this.ldCountryByCountryId = ldCountryByCountryId;
    }
}
