package Classes.repository;

import Classes.dbEntity.LdRoomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdRoomsRepository extends JpaRepository<LdRoomsEntity,Long> {
}
