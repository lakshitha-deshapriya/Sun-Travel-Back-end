package Classes.service;

import Classes.dbEntity.LdContractsEntity;
import Classes.repository.LdContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ContractServices {

    @Autowired
    private LdContractsRepository ldContractsRepository;

    public List<LdContractsEntity> getAllContracts(){
        return ldContractsRepository.findAll();
    }

    public void InsertContract(LdContractsEntity ldContractsEntity){
        this.ldContractsRepository.save(ldContractsEntity);
    }

    public List<LdContractsEntity> getContactByHotelName(String hotelName){
        List<LdContractsEntity> entities=ldContractsRepository.findByLdHotelByHotelIdHotelNameContainingIgnoreCase(hotelName);
        return entities;
    }
}
