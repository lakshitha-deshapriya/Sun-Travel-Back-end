package Classes.controller;

import Classes.dbEntity.LdCountryEntity;
import Classes.service.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("countries")
@CrossOrigin(origins = "*")
public class CountryController
{

	@Autowired
	private CountryServices countryServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdCountryEntity> getAllCountry()
	{
		return this.countryServices.getAllCountry();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCountry( @RequestBody LdCountryEntity ldCountryEntity )
	{
		this.countryServices.InsertCountry( ldCountryEntity );
	}

}
