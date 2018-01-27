package Classes.controller;

import Classes.dbEntity.LdCityEntity;
import Classes.service.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("cities")
@CrossOrigin(origins = "*")
public class CityController
{

	@Autowired
	private CityServices cityServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdCityEntity> getAlllCities()
	{
		return this.cityServices.getAllCities();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertingCity( @RequestBody LdCityEntity ldCityEntity )
	{
		this.cityServices.InsertCity( ldCityEntity );
	}
}
