package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_ROOM_TYPE", schema = "SYSTEM", catalog = "")
public class LdRoomTypeEntity {
    private long typeId;
    private String type;
    private Long noOfRooms;
    private Long maxAdults;
    private Double price;
    private Double markup;
    private LdContractsEntity ldContractsByContractId;

    @Id
    @Column(name = "TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_ROOM_TYPE_TYPE_ID_SEQ")
    @SequenceGenerator(sequenceName = "LD_ROOM_TYPE_TYPE_ID_SEQ", allocationSize = 1, name = "LD_ROOM_TYPE_TYPE_ID_SEQ")
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "NO_OF_ROOMS")
    public Long getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Long noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    @Basic
    @Column(name = "MAX_ADULTS")
    public Long getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(Long maxAdults) {
        this.maxAdults = maxAdults;
    }

    @Basic
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "MARKUP")
    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdRoomTypeEntity that = (LdRoomTypeEntity) o;

        if (typeId != that.typeId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (noOfRooms != null ? !noOfRooms.equals(that.noOfRooms) : that.noOfRooms != null) return false;
        if (maxAdults != null ? !maxAdults.equals(that.maxAdults) : that.maxAdults != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (markup != null ? !markup.equals(that.markup) : that.markup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (typeId ^ (typeId >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (noOfRooms != null ? noOfRooms.hashCode() : 0);
        result = 31 * result + (maxAdults != null ? maxAdults.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (markup != null ? markup.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "CONTRACT_ID", nullable = false)
    public LdContractsEntity getLdContractsByContractId() {
        return ldContractsByContractId;
    }

    public void setLdContractsByContractId(LdContractsEntity ldContractsByContractId) {
        this.ldContractsByContractId = ldContractsByContractId;
    }
}
