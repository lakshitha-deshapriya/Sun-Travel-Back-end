package Classes.service;

import Classes.dbEntity.LdRoomTypeEntity;
import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import Classes.repository.LdRoomTypeRepository;
import Classes.repository.LdRoomtypeAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AvailabilityServices
{
	@Autowired
	private LdRoomtypeAvailabilityRepository ldRoomtypeAvailabilityRepository;

	@Autowired
	private LdRoomTypeRepository ldRoomTypeRepository;

	public List<LdRoomtypeAvailabilityEntity> getAllAvailabilities()
	{
		return ldRoomtypeAvailabilityRepository.findAll();
	}

	public LdRoomtypeAvailabilityEntity InsertRoomAvailability( LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity )
	{
		return this.ldRoomtypeAvailabilityRepository.save( ldRoomtypeAvailabilityEntity );
	}

	public void updateAvailabilityForDate( LdRoomtypeAvailabilityEntity updatedAvailability )
	{
		LdRoomtypeAvailabilityEntity current_availability = ldRoomtypeAvailabilityRepository.findOne( updatedAvailability.getAvailabilityId() );
		current_availability.setAvailableNoRooms( updatedAvailability.getAvailableNoRooms() );
		ldRoomtypeAvailabilityRepository.save( current_availability );
	}

	public List<LdRoomtypeAvailabilityEntity> getAvailabilityByDate( Date availableDate )
	{
		return ldRoomtypeAvailabilityRepository.findByAvailableDate( availableDate );
	}

	public LdRoomtypeAvailabilityEntity getAvailabilityByRoomType( Long typeId, Date date )
	{
		return ldRoomtypeAvailabilityRepository.findByLdRoomTypeByTypeIdTypeIdAndAvailableDate( typeId, date );
	}

	public Long getAvailabilityCount( Date availableDate )
	{
		return ldRoomtypeAvailabilityRepository.countByAvailableDate( availableDate );
	}

	public LdRoomtypeAvailabilityEntity updateAvailability( LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity )
	{
		LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity1 = this.ldRoomtypeAvailabilityRepository.findByAvailableDateAndLdRoomTypeByTypeId( ldRoomtypeAvailabilityEntity.getAvailableDate(), ldRoomtypeAvailabilityEntity.getLdRoomTypeByTypeId() );
		if ( ldRoomtypeAvailabilityEntity1 == null )
		{
			LdRoomTypeEntity ldRoomTypeEntity = this.ldRoomTypeRepository.findOne( ldRoomtypeAvailabilityEntity.getLdRoomTypeByTypeId().getTypeId() );

			LdRoomtypeAvailabilityEntity newentity = new LdRoomtypeAvailabilityEntity();
			newentity.setLdRoomTypeByTypeId( ldRoomTypeEntity );
			newentity.setAvailableDate( ldRoomtypeAvailabilityEntity.getAvailableDate() );
			newentity.setAvailableNoRooms( ldRoomTypeEntity.getNoOfRooms() - ldRoomtypeAvailabilityEntity.getAvailableNoRooms() );

			return this.ldRoomtypeAvailabilityRepository.save( newentity );
		}
		else
		{
			ldRoomtypeAvailabilityEntity1.setAvailableNoRooms( ldRoomtypeAvailabilityEntity1.getAvailableNoRooms() - ldRoomtypeAvailabilityEntity.getAvailableNoRooms() );
			return this.ldRoomtypeAvailabilityRepository.save( ldRoomtypeAvailabilityEntity1 );
		}
	}
	//    }
	//        return ldRoomtypeAvailabilityRepository.findByAvailableNoRoomsIsGreaterThanEqualAndLdRoomTypeByTypeIdMaxAdultsIsGreaterThanEqualAndAvailableDate(noRooms,noAdults, availableDate);
	//    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByNoRoomsAndNoAdults(Long noRooms, Long noAdults, Date availableDate){
	//    }
	//        return ldRoomtypeAvailabilityRepository.findByAvailableDateWithin()
	//    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByNoNIghts(Date date1, Date date2){
	//
	//    }
	//        return ldRoomtypeAvailabilityRepository.findByAvailableDateAndAvailableNoRoomsIsGreaterThanEqual(availableDate, noRooms);
	//    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByDateAndNoRooms(Date availableDate, Long noRooms){
}
