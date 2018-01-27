package Classes.repository;

import Classes.dbEntity.LdCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdCountryRepository extends JpaRepository<LdCountryEntity, Long>
{

	LdCountryEntity findByCountryNameIgnoreCase( String hotelName );
}
