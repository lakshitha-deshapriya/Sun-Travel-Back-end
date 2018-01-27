package Classes.service;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdHotelEntity;
import Classes.repository.LdHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices
{

	@Autowired
	private LdHotelRepository ldHotelRepository;

	public List<LdHotelEntity> getAllHotels()
	{
		return ldHotelRepository.findAll();
	}

	public LdHotelEntity InsertHotel( LdHotelEntity ldHotelEntity )
	{
		return this.ldHotelRepository.save( ldHotelEntity );
	}

	public LdHotelEntity getHotelByName( String hotelName )
	{
		return this.ldHotelRepository.findByHotelName( hotelName );
	}

	public LdHotelEntity getHotelByHotelNameAndAddress( String hotelName, LdAddressEntity ldAddressEntity )
	{
		return this.ldHotelRepository.findByHotelNameAndLdAddressByAddressId( hotelName, ldAddressEntity );
	}
}
