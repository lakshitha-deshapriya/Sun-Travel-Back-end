package Classes.repository;

import Classes.dbEntity.LdAccommodationRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdAccommodationRoomRepository extends JpaRepository<LdAccommodationRoomEntity, Long> {
}
