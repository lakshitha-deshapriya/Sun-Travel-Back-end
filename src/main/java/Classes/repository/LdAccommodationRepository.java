package Classes.repository;

import Classes.dbEntity.LdAccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdAccommodationRepository extends JpaRepository<LdAccommodationEntity,Long>{
}
