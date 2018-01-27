package Classes.repository;

import Classes.dbEntity.LdContractsEntity;
import Classes.dbEntity.LdHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LdContractsRepository extends JpaRepository<LdContractsEntity, Long>
{

	LdContractsEntity findByLdHotelByHotelIdAndStartDateAndEndDate( LdHotelEntity ldHotelEntity, Date startdate, Date enddate );

	List<LdContractsEntity> findByLdHotelByHotelIdAndStartDateIsLessThanEqualOrEndDateIsGreaterThanEqual( LdHotelEntity ldHotelEntity, Date startdate, Date enddate );

}
