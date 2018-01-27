package Classes.repository;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdCustomerRepository extends JpaRepository<LdCustomerEntity, Long>
{

	LdCustomerEntity findByFNameAndLNameAndLdAddressByAddressId( String fname, String lname, LdAddressEntity ldAddressEntity );

}
