package Classes.repository;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdAddressRepository extends JpaRepository<LdAddressEntity, Long>
{

	LdAddressEntity findByPostBoxNoAndRegionAndLdCityByCityId( String pbox, String region, LdCityEntity ldCityEntity );

}
