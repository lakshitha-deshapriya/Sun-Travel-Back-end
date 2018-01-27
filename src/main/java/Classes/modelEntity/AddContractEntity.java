package Classes.modelEntity;

import java.util.List;

public class AddContractEntity
{
	private String hotelName;
	private String roomType;
	private String startDate;
	private String endDate;
	private Long noOfRooms;
	private Long maxAdults;
	private Double price;
	private Double markup;
	private String phone;
	private String email;
	private String pbox;
	private String region;
	private String city;
	private String country;
	private String zipcode;
	private String description;

	public AddContractEntity()
	{
	}

	public AddContractEntity( String hotelName, String roomType, String startDate, String endDate, Long noOfRooms, Long maxAdults, Double price, Double markup, String phone, String email, String pbox, String region, String city, String country, String zipcode, String description )
	{
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noOfRooms = noOfRooms;
		this.maxAdults = maxAdults;
		this.price = price;
		this.markup = markup;
		this.phone = phone;
		this.email = email;
		this.pbox = pbox;
		this.region = region;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.description = description;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public void setRoomType( String roomType )
	{
		this.roomType = roomType;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate( String startDate )
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate( String endDate )
	{
		this.endDate = endDate;
	}

	public Long getNoOfRooms()
	{
		return noOfRooms;
	}

	public void setNoOfRooms( Long noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	public Long getMaxAdults()
	{
		return maxAdults;
	}

	public void setMaxAdults( Long maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

	public Double getMarkup()
	{
		return markup;
	}

	public void setMarkup( Double markup )
	{
		this.markup = markup;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}
}
