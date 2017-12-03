package Classes.repository;

import Classes.dbEntity.LdRoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LdRoomTypeRepository extends JpaRepository<LdRoomTypeEntity,Long> {

    List<LdRoomTypeEntity> findByLdContractsByContractIdEndDateGreaterThanEqualAndLdContractsByContractIdStartDateLessThanEqual(Date date1, Date date2);

}
