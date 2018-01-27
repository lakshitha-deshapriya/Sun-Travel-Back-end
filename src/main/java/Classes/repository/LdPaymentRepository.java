package Classes.repository;

import Classes.dbEntity.LdPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdPaymentRepository extends JpaRepository<LdPaymentEntity, Long>
{
}
