package Classes.service;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdCityEntity;
import Classes.repository.LdAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServices
{

	@Autowired
	private LdAddressRepository ldAddressRepository;

	public List<LdAddressEntity> getAllAddresses()
	{
		return this.ldAddressRepository.findAll();
	}

	public LdAddressEntity insertAddress( LdAddressEntity ldAddressEntity )
	{
		return this.ldAddressRepository.save( ldAddressEntity );
	}

	public LdAddressEntity getAddressByData( String pbox, String region, LdCityEntity ldCityEntity )
	{
		return this.ldAddressRepository.findByPostBoxNoAndRegionAndLdCityByCityId( pbox, region, ldCityEntity );
	}

	public LdAddressEntity saveOrReturnAddress( String pbox, String region, Long zipcode, LdCityEntity ldCityEntity )
	{
		LdAddressEntity ldAddressEntity = this.getAddressByData( pbox, region, ldCityEntity );
		if ( ldAddressEntity == null )
		{
			LdAddressEntity ldAddressEntitynew = new LdAddressEntity();

			ldAddressEntitynew.setPostBoxNo( pbox );
			ldAddressEntitynew.setRegion( region );
			ldAddressEntitynew.setZipcode( zipcode );
			ldAddressEntitynew.setLdCityByCityId( ldCityEntity );

			return this.insertAddress( ldAddressEntitynew );
		}
		else
		{
			return ldAddressEntity;
		}
	}
}
