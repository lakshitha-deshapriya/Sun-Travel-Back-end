package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_HOTEL", schema = "SYSTEM", catalog = "")
public class LdHotelEntity
{
	private long hotelId;
	private String hotelName;
	private String description;
	private LdAddressEntity ldAddressByAddressId;

	@Id
	@Column(name = "HOTEL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_HOTEL_HOTEL_ID_SEQ")
	@SequenceGenerator(sequenceName = "LD_HOTEL_HOTEL_ID_SEQ", allocationSize = 1, name = "LD_HOTEL_HOTEL_ID_SEQ")
	public long getHotelId()
	{
		return hotelId;
	}

	public void setHotelId( long hotelId )
	{
		this.hotelId = hotelId;
	}

	@Basic
	@Column(name = "HOTEL_NAME")
	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	@Basic
	@Column(name = "DESCRIPTION")
	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdHotelEntity that = ( LdHotelEntity ) o;

		if ( hotelId != that.hotelId )
			return false;
		if ( hotelName != null ? !hotelName.equals( that.hotelName ) : that.hotelName != null )
			return false;
		if ( description != null ? !description.equals( that.description ) : that.description != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( hotelId ^ ( hotelId >>> 32 ) );
		result = 31 * result + ( hotelName != null ? hotelName.hashCode() : 0 );
		result = 31 * result + ( description != null ? description.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
	public LdAddressEntity getLdAddressByAddressId()
	{
		return ldAddressByAddressId;
	}

	public void setLdAddressByAddressId( LdAddressEntity ldAddressByAddressId )
	{
		this.ldAddressByAddressId = ldAddressByAddressId;
	}
}
