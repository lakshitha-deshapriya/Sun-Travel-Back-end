package Classes.service;

import Classes.dbEntity.LdCustomerEntity;
import Classes.repository.LdCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    private LdCustomerRepository ldCustomerRepository;

    public List<LdCustomerEntity> getAllCustomers(){
        return ldCustomerRepository.findAll();
    }

    public void InsertCustomer(LdCustomerEntity ldCustomerEntity){
        this.ldCustomerRepository.save(ldCustomerEntity);
    }
}
