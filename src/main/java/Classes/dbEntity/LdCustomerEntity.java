package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_CUSTOMER", schema = "SYSTEM", catalog = "")
public class LdCustomerEntity
{
	private long customerId;
	private String fName;
	private String lName;
	private String phoneNumber;
	private String email;
	private LdAddressEntity ldAddressByAddressId;

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_CUSTOMER_CUSTOMER_ID_SEQ")
	@SequenceGenerator(sequenceName = "LD_CUSTOMER_CUSTOMER_ID_SEQ", allocationSize = 1, name = "LD_CUSTOMER_CUSTOMER_ID_SEQ")
	public long getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId( long customerId )
	{
		this.customerId = customerId;
	}

	@Basic
	@Column(name = "F_NAME")
	public String getfName()
	{
		return fName;
	}

	public void setfName( String fName )
	{
		this.fName = fName;
	}

	@Basic
	@Column(name = "L_NAME")
	public String getlName()
	{
		return lName;
	}

	public void setlName( String lName )
	{
		this.lName = lName;
	}

	@Basic
	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber )
	{
		this.phoneNumber = phoneNumber;
	}

	@Basic
	@Column(name = "EMAIL")
	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdCustomerEntity that = ( LdCustomerEntity ) o;

		if ( customerId != that.customerId )
			return false;
		if ( !fName.equals( that.fName ) )
			return false;
		if ( lName != null ? !lName.equals( that.lName ) : that.lName != null )
			return false;
		if ( !phoneNumber.equals( that.phoneNumber ) )
			return false;
		if ( !email.equals( that.email ) )
			return false;
		return ldAddressByAddressId.equals( that.ldAddressByAddressId );
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( customerId ^ ( customerId >>> 32 ) );
		result = 31 * result + fName.hashCode();
		result = 31 * result + ( lName != null ? lName.hashCode() : 0 );
		result = 31 * result + phoneNumber.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + ldAddressByAddressId.hashCode();
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
