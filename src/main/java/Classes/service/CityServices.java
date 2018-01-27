package Classes.service;

import Classes.dbEntity.LdCityEntity;
import Classes.dbEntity.LdCountryEntity;
import Classes.repository.LdCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServices
{

	@Autowired
	private LdCityRepository ldCityRepository;

	public List<LdCityEntity> getAllCities()
	{
		return ldCityRepository.findAll();
	}

	public LdCityEntity InsertCity( LdCityEntity ldCityEntity )
	{
		return this.ldCityRepository.save( ldCityEntity );
	}

	public LdCityEntity getCityByName( String cityName )
	{
		return this.ldCityRepository.findByCityName( cityName );
	}

	public LdCityEntity saveOrReturnCity( String cityName, LdCountryEntity ldCountryEntity )
	{
		LdCityEntity ldCityEntity = this.getCityByName( cityName );
		if ( ldCityEntity == null )
		{
			LdCityEntity ldCityEntitynew = new LdCityEntity();

			ldCityEntitynew.setCityName( cityName );
			ldCityEntitynew.setLdCountryByCountryId( ldCountryEntity );

			try
			{
				return this.InsertCity( ldCityEntitynew );
			}
			catch ( Exception e )
			{
				e.printStackTrace();
				return null;
			}

		}
		else
		{
			return ldCityEntity;
		}
	}

}
