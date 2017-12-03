package Classes.dbEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LdAccommodationRoomEntityPK implements Serializable{
    @Column(name = "ACCOMMODATION_ID")
    private long accommodationId;

    @Column(name = "ROOM_ID")
    private long roomId;

    public LdAccommodationRoomEntityPK()
    {
    }

    public LdAccommodationRoomEntityPK( long accommodationId, long roomId )
    {
        this.roomId = roomId;
        this.accommodationId = accommodationId;
    }

    public long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
