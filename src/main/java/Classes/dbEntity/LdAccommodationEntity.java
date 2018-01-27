package Classes.dbEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "LD_ACCOMMODATION", schema = "SYSTEM", catalog = "")
public class LdAccommodationEntity
{
	private long accommodationId;
	private Date checkInDate;
	private LdCustomerEntity ldCustomerByCustomerId;

	@Id
	@Column(name = "ACCOMMODATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_ACCOMMODATION_ACCOMMODATION")
	@SequenceGenerator(sequenceName = "LD_ACCOMMODATION_ACCOMMODATION", allocationSize = 1, name = "LD_ACCOMMODATION_ACCOMMODATION")
	public long getAccommodationId()
	{
		return accommodationId;
	}

	public void setAccommodationId( long accommodationId )
	{
		this.accommodationId = accommodationId;
	}

	@Basic
	@Column(name = "CHECK_IN_DATE")
	public Date getCheckInDate()
	{
		return checkInDate;
	}

	public void setCheckInDate( Date checkInDate )
	{
		this.checkInDate = checkInDate;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdAccommodationEntity that = ( LdAccommodationEntity ) o;

		if ( accommodationId != that.accommodationId )
			return false;
		if ( checkInDate != null ? !checkInDate.equals( that.checkInDate ) : that.checkInDate != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( accommodationId ^ ( accommodationId >>> 32 ) );
		result = 31 * result + ( checkInDate != null ? checkInDate.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
	public LdCustomerEntity getLdCustomerByCustomerId()
	{
		return ldCustomerByCustomerId;
	}

	public void setLdCustomerByCustomerId( LdCustomerEntity ldCustomerByCustomerId )
	{
		this.ldCustomerByCustomerId = ldCustomerByCustomerId;
	}
}
