package Classes.repository;

import Classes.dbEntity.LdAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdAddressRepository extends JpaRepository<LdAddressEntity,Long> {
}
