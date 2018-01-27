package Classes.modelEntity;

import java.sql.Date;

public class ReservationEntity
{
	private String hotelName;
	private String roomtype;
	private String checkindate;
	private Long noofrooms;
	private Long noofnights;
	private Long noofadults;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private String pbox;
	private String region;
	private String city;
	private String country;
	private String zipcode;

	public ReservationEntity()
	{
	}

	public ReservationEntity( String hotelName, String roomtype, String checkindate, Long noofrooms, Long noofnights, Long noofadults, String fname, String lname, String phone, String email, String pbox, String region, String city, String country, String zipcode )
	{
		this.hotelName = hotelName;
		this.roomtype = roomtype;
		this.checkindate = checkindate;
		this.noofrooms = noofrooms;
		this.noofnights = noofnights;
		this.noofadults = noofadults;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.pbox = pbox;
		this.region = region;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public String getRoomtype()
	{
		return roomtype;
	}

	public void setRoomtype( String roomtype )
	{
		this.roomtype = roomtype;
	}

	public String getCheckindate()
	{
		return checkindate;
	}

	public void setCheckindate( String checkindate )
	{
		this.checkindate = checkindate;
	}

	public Long getNoofrooms()
	{
		return noofrooms;
	}

	public void setNoofrooms( Long noofrooms )
	{
		this.noofrooms = noofrooms;
	}

	public Long getNoofnights()
	{
		return noofnights;
	}

	public void setNoofnights( Long noofnights )
	{
		this.noofnights = noofnights;
	}

	public Long getNoofadults()
	{
		return noofadults;
	}

	public void setNoofadults( Long noofadults )
	{
		this.noofadults = noofadults;
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname( String fname )
	{
		this.fname = fname;
	}

	public String getLname()
	{
		return lname;
	}

	public void setLname( String lname )
	{
		this.lname = lname;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPbox()
	{
		return pbox;
	}

	public void setPbox( String pbox )
	{
		this.pbox = pbox;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion( String region )
	{
		this.region = region;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity( String city )
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry( String country )
	{
		this.country = country;
	}

	public String getZipcode()
	{
		return zipcode;
	}

	public void setZipcode( String zipcode )
	{
		this.zipcode = zipcode;
	}
}
