package Classes.repository;

import Classes.dbEntity.LdContractsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LdContractsRepository extends JpaRepository<LdContractsEntity,Long>  {

    List<LdContractsEntity> findByLdHotelByHotelIdHotelNameContainingIgnoreCase(String hotelName);

}
