package Classes.modelEntity;

public class MultipleRoomType
{
	private String roomType;
	private Long noOfRooms;
	private Long maxAdults;
	private Double price;
	private Double markup;

	public MultipleRoomType()
	{
	}

	public MultipleRoomType( String roomType, Long noOfRooms, Long maxAdults, Double price, Double markup )
	{
		this.roomType = roomType;
		this.noOfRooms = noOfRooms;
		this.maxAdults = maxAdults;
		this.price = price;
		this.markup = markup;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public void setRoomType( String roomType )
	{
		this.roomType = roomType;
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
}
