package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_ROOMS", schema = "SYSTEM", catalog = "")
public class LdRoomsEntity
{
	private long roomId;
	private String roomName;
	private LdRoomTypeEntity ldRoomTypeByTypeId;

	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_ROOMS_ROOM_ID_SEQ")
	@SequenceGenerator(sequenceName = "LD_ROOMS_ROOM_ID_SEQ", allocationSize = 1, name = "LD_ROOMS_ROOM_ID_SEQ")
	public long getRoomId()
	{
		return roomId;
	}

	public void setRoomId( long roomId )
	{
		this.roomId = roomId;
	}

	@Basic
	@Column(name = "ROOM_NAME")
	public String getRoomName()
	{
		return roomName;
	}

	public void setRoomName( String roomName )
	{
		this.roomName = roomName;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdRoomsEntity that = ( LdRoomsEntity ) o;

		if ( roomId != that.roomId )
			return false;
		if ( roomName != null ? !roomName.equals( that.roomName ) : that.roomName != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( roomId ^ ( roomId >>> 32 ) );
		result = 31 * result + ( roomName != null ? roomName.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false)
	public LdRoomTypeEntity getLdRoomTypeByTypeId()
	{
		return ldRoomTypeByTypeId;
	}

	public void setLdRoomTypeByTypeId( LdRoomTypeEntity ldRoomTypeByTypeId )
	{
		this.ldRoomTypeByTypeId = ldRoomTypeByTypeId;
	}
}
