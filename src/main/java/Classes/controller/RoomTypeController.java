package Classes.controller;

import Classes.dbEntity.LdRoomTypeEntity;
import Classes.service.RoomTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

@RestController
@RequestMapping("roomtype")
@CrossOrigin(origins = "*")
public class RoomTypeController
{

	@Autowired
	private RoomTypeServices roomTypeServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdRoomTypeEntity> getAllContracts()
	{
		return this.roomTypeServices.getAllRoomTypes();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCountry( @RequestBody LdRoomTypeEntity ldRoomTypeEntity )
	{
		this.roomTypeServices.InsertRoomType( ldRoomTypeEntity );
	}

	@RequestMapping(value = "/search/{availableDate}", method = RequestMethod.GET)
	public Collection<LdRoomTypeEntity> getdetails( @PathVariable String availableDate ) throws ParseException
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd" );
		java.util.Date date = sdf1.parse( availableDate );

		return this.roomTypeServices.getRoomTypeforAvailability( date );
	}

	@RequestMapping(value = "searchByHotel/{hotelName}", method = RequestMethod.GET)
	public Collection<LdRoomTypeEntity> getRoomTypesByHotelName( @PathVariable String hotelName )
	{
		return this.roomTypeServices.getRoomTypeByHotelName( hotelName );
	}
}
