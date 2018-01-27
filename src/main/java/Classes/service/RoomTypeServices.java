package Classes.service;

import Classes.dbEntity.LdContractsEntity;
import Classes.dbEntity.LdRoomTypeEntity;
import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import Classes.repository.LdRoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomTypeServices
{

	@Autowired
	private LdRoomTypeRepository ldRoomTypeRepository;

	public List<LdRoomTypeEntity> getAllRoomTypes()
	{
		return ldRoomTypeRepository.findAll();
	}

	public void InsertRoomType( LdRoomTypeEntity ldRoomTypeEntity )
	{
		this.ldRoomTypeRepository.save( ldRoomTypeEntity );
	}

	public List<LdRoomTypeEntity> getRoomTypeforAvailability( Date date )
	{
		return this.ldRoomTypeRepository.findByLdContractsByContractIdEndDateGreaterThanEqualAndLdContractsByContractIdStartDateLessThanEqual( date, date );
	}

	public List<LdRoomTypeEntity> getRoomTypeByHotelName( String hotelName )
	{
		return this.ldRoomTypeRepository.findByLdContractsByContractIdLdHotelByHotelIdHotelName( hotelName );
	}

	public LdRoomTypeEntity getRoomTypeByName( String roomType )
	{
		return this.ldRoomTypeRepository.findByType( roomType );
	}

	public Long getRoomTypeCount( Date date )
	{
		return this.ldRoomTypeRepository.countByLdContractsByContractIdEndDateGreaterThanEqualAndLdContractsByContractIdStartDateLessThanEqual( date, date );
	}

	public ArrayList<LdRoomTypeEntity> getRoomTypeByContract( LdContractsEntity ldContractsEntity )
	{
		return this.ldRoomTypeRepository.findByLdContractsByContractId( ldContractsEntity );
	}

}
