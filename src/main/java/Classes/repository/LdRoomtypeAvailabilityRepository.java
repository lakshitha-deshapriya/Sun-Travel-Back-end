package Classes.repository;

import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface LdRoomtypeAvailabilityRepository extends JpaRepository<LdRoomtypeAvailabilityEntity,Long> {

    List<LdRoomtypeAvailabilityEntity> findByAvailableDate(Date availableDate);

    List<LdRoomtypeAvailabilityEntity> findByAvailableDateAndAvailableNoRoomsIsGreaterThanEqual(Date availableDate, Long noRooms);

    List<LdRoomtypeAvailabilityEntity> findByAvailableNoRoomsIsGreaterThanEqualAndLdRoomTypeByTypeIdMaxAdultsIsGreaterThanEqualAndAvailableDate(Long noRooms, Long adults,Date availableDate);
}
