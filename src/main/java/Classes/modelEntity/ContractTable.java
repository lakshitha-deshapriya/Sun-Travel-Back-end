package Classes.modelEntity;

import java.util.ArrayList;
import java.util.Date;

public class ContractTable
{
	private String hotelName;
	private Date startDate;
	private Date endDate;
	private String roomTypes;
	private Long contractId;

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate( Date startDate )
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate( Date endDate )
	{
		this.endDate = endDate;
	}

	public String getRoomTypes()
	{
		return roomTypes;
	}

	public void setRoomTypes( String roomTypes )
	{
		this.roomTypes = roomTypes;
	}

	public Long getContractId()
	{
		return contractId;
	}

	public void setContractId( Long contractId )
	{
		this.contractId = contractId;
	}
}
