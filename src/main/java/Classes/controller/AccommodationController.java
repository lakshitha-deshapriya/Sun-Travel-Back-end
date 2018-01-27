package Classes.controller;

import Classes.dbEntity.LdAccommodationEntity;
import Classes.service.AccommodationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("accommodation")
@CrossOrigin(origins = "*")
public class AccommodationController
{

	@Autowired
	private AccommodationServices accommodationServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdAccommodationEntity> getAllContracts()
	{
		return this.accommodationServices.getAllAccommodations();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCountry( @RequestBody LdAccommodationEntity ldAccommodationEntity )
	{
		this.accommodationServices.InsertAccommodation( ldAccommodationEntity );
	}
}
