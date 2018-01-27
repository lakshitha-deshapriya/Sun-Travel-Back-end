package Classes.controller;

import Classes.dbEntity.LdCustomerEntity;
import Classes.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "*")
public class CustomerController
{

	@Autowired
	private CustomerServices customerServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdCustomerEntity> getAllCustomers()
	{
		return this.customerServices.getAllCustomers();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCustomer( @RequestBody LdCustomerEntity ldCustomerEntity )
	{
		this.customerServices.InsertCustomer( ldCustomerEntity );
	}
}
