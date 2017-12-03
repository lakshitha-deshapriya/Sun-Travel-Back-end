package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_ACCOMMODATION_ROOM")
public class LdAccommodationRoomEntity {
    @EmbeddedId
    protected LdAccommodationRoomEntityPK ldAccommodationtionRoomEntityPK = new LdAccommodationRoomEntityPK();

    @MapsId("accommodationId")
    @ManyToOne
    @JoinColumn(name = "ACCOMMODATION_ID", referencedColumnName = "ACCOMMODATION_ID", nullable = false)
    private LdAccommodationEntity ldAccommodationEntity;

    @MapsId("roomId")
    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", nullable = false)
    private LdRoomsEntity ldRoomsEntity;

    @Column(name = "NO_OF_NIGHTS")
    private long numberOfAdults;

    @Column(name = "NO_OF_ADULTS")
    private long numberOfNights;

    public LdAccommodationRoomEntity()
    {
    }

    public LdAccommodationRoomEntity( LdAccommodationEntity ldAccommodationEntity, LdRoomsEntity ldRoomsEntity )
    {
        this.ldAccommodationEntity = ldAccommodationEntity;
        this.ldRoomsEntity = ldRoomsEntity;

        this.ldAccommodationtionRoomEntityPK.setAccommodationId(ldAccommodationEntity.getAccommodationId());
        this.ldAccommodationtionRoomEntityPK.setRoomId(ldRoomsEntity.getRoomId());
    }

    public LdAccommodationRoomEntityPK getLdAccommodationRoomEntityPK()
    {
        return ldAccommodationtionRoomEntityPK;
    }

    public void setLdAccommodationRoomEntityPK( LdAccommodationRoomEntityPK ldAccommodationtionRoomEntityPK )
    {
        this.ldAccommodationtionRoomEntityPK = ldAccommodationtionRoomEntityPK;
    }

    public long getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(long numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public long getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(long numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public LdAccommodationEntity getLdAccommodationEntity()
    {
        return ldAccommodationEntity;
    }

    public void setLdAccommodationEntity( LdAccommodationEntity ldAccommodationEntity )
    {
        this.ldAccommodationEntity = ldAccommodationEntity;
    }

    public LdRoomsEntity getLdRoomsEntity()
    {
        return ldRoomsEntity;
    }

    public void setLdRoomsEntity( LdRoomsEntity ldRoomsEntity )
    {
        this.ldRoomsEntity = ldRoomsEntity;
    }

}
