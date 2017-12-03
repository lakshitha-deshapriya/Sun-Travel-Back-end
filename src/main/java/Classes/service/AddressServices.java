package Classes.service;

import Classes.dbEntity.LdAddressEntity;
import Classes.repository.LdAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServices {

    @Autowired
    private LdAddressRepository ldAddressRepository;

    public List<LdAddressEntity> getAllAddresses(){
        return this.ldAddressRepository.findAll();
    }

    public void insertAddress(LdAddressEntity ldAddressEntity){
        this.ldAddressRepository.save(ldAddressEntity);
    }
}
