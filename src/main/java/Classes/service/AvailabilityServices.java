package Classes.service;

import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import Classes.repository.LdRoomtypeAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AvailabilityServices {
    @Autowired
    private LdRoomtypeAvailabilityRepository ldRoomtypeAvailabilityRepository;

    public List<LdRoomtypeAvailabilityEntity> getAllAvailabilities(){
        return ldRoomtypeAvailabilityRepository.findAll();
    }

    public void InsertRoomAvailability(LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity){
        this.ldRoomtypeAvailabilityRepository.save(ldRoomtypeAvailabilityEntity);
    }

    public void updateAvailabilityForDate(LdRoomtypeAvailabilityEntity updatedAvailability) {
        LdRoomtypeAvailabilityEntity current_availability = ldRoomtypeAvailabilityRepository.findOne(updatedAvailability.getAvailabilityId());
        current_availability.setAvailableNoRooms(updatedAvailability.getAvailableNoRooms());
        ldRoomtypeAvailabilityRepository.save(current_availability);
    }

    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByDate(Date availableDate){
        return ldRoomtypeAvailabilityRepository.findByAvailableDate(availableDate);
    }

    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByDateAndNoRooms(Date availableDate, Long noRooms){
        return ldRoomtypeAvailabilityRepository.findByAvailableDateAndAvailableNoRoomsIsGreaterThanEqual(availableDate, noRooms);
    }

//    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByNoNIghts(Date date1, Date date2){
//        return ldRoomtypeAvailabilityRepository.findByAvailableDateWithin()
//    }
    public List<LdRoomtypeAvailabilityEntity> getAvailabilityByNoRoomsAndNoAdults(Long noRooms, Long noAdults, Date availableDate){
        return ldRoomtypeAvailabilityRepository.findByAvailableNoRoomsIsGreaterThanEqualAndLdRoomTypeByTypeIdMaxAdultsIsGreaterThanEqualAndAvailableDate(noRooms,noAdults, availableDate);
    }
}
