package Classes.service;

import Classes.dbEntity.LdAddressEntity;
import Classes.dbEntity.LdCustomerEntity;
import Classes.repository.LdCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices
{

	@Autowired
	private LdCustomerRepository ldCustomerRepository;

	public List<LdCustomerEntity> getAllCustomers()
	{
		return ldCustomerRepository.findAll();
	}

	public LdCustomerEntity InsertCustomer( LdCustomerEntity ldCustomerEntity )
	{
		return this.ldCustomerRepository.save( ldCustomerEntity );
	}

	public LdCustomerEntity getCustomerByData( String fname, String lname, LdAddressEntity ldAddressEntity )
	{
		return this.ldCustomerRepository.findByFNameAndLNameAndLdAddressByAddressId( fname, lname, ldAddressEntity );
	}
}
