package Classes.dbEntity;

import javax.persistence.*;

@Entity
@Table(name = "LD_COUNTRY", schema = "SYSTEM", catalog = "")
public class LdCountryEntity
{
	private long countryId;
	private String countryName;

	@Id
	@Column(name = "COUNTRY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LD_COUNTRY_COUNTRY_ID_SEQ")
	@SequenceGenerator(sequenceName = "LD_COUNTRY_COUNTRY_ID_SEQ", allocationSize = 1, name = "LD_COUNTRY_COUNTRY_ID_SEQ")
	public long getCountryId()
	{
		return countryId;
	}

	public void setCountryId( long countryId )
	{
		this.countryId = countryId;
	}

	@Basic
	@Column(name = "COUNTRY_NAME")
	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName( String countryName )
	{
		this.countryName = countryName;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		LdCountryEntity that = ( LdCountryEntity ) o;

		if ( countryId != that.countryId )
			return false;
		if ( countryName != null ? !countryName.equals( that.countryName ) : that.countryName != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( countryId ^ ( countryId >>> 32 ) );
		result = 31 * result + ( countryName != null ? countryName.hashCode() : 0 );
		return result;
	}
}
