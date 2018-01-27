package Classes.repository;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdHotelRepository extends JpaRepository<LdHotelEntity, Long>
{

	LdHotelEntity findByHotelName( String hotelName );

	LdHotelEntity findByHotelNameAndLdAddressByAddressId( String hotelName, LdAddressEntity ldAddressEntity );
}
