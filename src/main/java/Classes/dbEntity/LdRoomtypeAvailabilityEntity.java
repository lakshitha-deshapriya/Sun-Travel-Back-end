package Classes.dbEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "LD_ROOMTYPE_AVAILABILITY", schema = "SYSTEM", catalog = "")
public class LdRoomtypeAvailabilityEntity
{
	private long availabilityId;
	private Date availableDate;
	private Long availableNoRooms;
	private LdRoomTypeEntity ldRoomTypeByTypeId;

	@Id
	@Column(name = "AVAILABILITY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_ROOMTYPE_AVAILABILITY_AVAIL")
	@SequenceGenerator(sequenceName = "LD_ROOMTYPE_AVAILABILITY_AVAIL", allocationSize = 1, name = "LD_ROOMTYPE_AVAILABILITY_AVAIL")
	public long getAvailabilityId()
	{
		return availabilityId;
	}

	public void setAvailabilityId( long availabilityId )
	{
		this.availabilityId = availabilityId;
	}

	@Basic
	@Column(name = "AVAILABLE_DATE")
	public Date getAvailableDate()
	{
		return availableDate;
	}

	public void setAvailableDate( Date availableDate )
	{
		this.availableDate = availableDate;
	}

	@Basic
	@Column(name = "AVAILABLE_NO_ROOMS")
	public Long getAvailableNoRooms()
	{
		return availableNoRooms;
	}

	public void setAvailableNoRooms( Long availableNoRooms )
	{
		this.availableNoRooms = availableNoRooms;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdRoomtypeAvailabilityEntity that = ( LdRoomtypeAvailabilityEntity ) o;

		if ( availabilityId != that.availabilityId )
			return false;
		if ( availableDate != null ? !availableDate.equals( that.availableDate ) : that.availableDate != null )
			return false;
		if ( availableNoRooms != null ? !availableNoRooms.equals( that.availableNoRooms ) : that.availableNoRooms != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( availabilityId ^ ( availabilityId >>> 32 ) );
		result = 31 * result + ( availableDate != null ? availableDate.hashCode() : 0 );
		result = 31 * result + ( availableNoRooms != null ? availableNoRooms.hashCode() : 0 );
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
