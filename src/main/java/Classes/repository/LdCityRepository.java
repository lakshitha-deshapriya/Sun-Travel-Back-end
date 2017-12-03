package Classes.repository;

import Classes.dbEntity.LdCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdCityRepository extends JpaRepository<LdCityEntity,Long>{



}
