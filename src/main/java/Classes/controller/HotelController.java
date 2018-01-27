package Classes.controller;

import Classes.dbEntity.LdHotelEntity;
import Classes.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("hotels")
@CrossOrigin(origins = "*")
public class HotelController
{

	@Autowired
	private HotelServices hotelServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdHotelEntity> getAllCountry()
	{
		return this.hotelServices.getAllHotels();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCountry( @RequestBody LdHotelEntity ldHotelEntity )
	{
		this.hotelServices.InsertHotel( ldHotelEntity );
	}

}
