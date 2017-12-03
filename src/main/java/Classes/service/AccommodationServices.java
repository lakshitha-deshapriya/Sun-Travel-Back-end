package Classes.service;

import Classes.dbEntity.LdAccommodationEntity;
import Classes.repository.LdAccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServices {

    @Autowired
    private LdAccommodationRepository ldAccommodationRepository;

    public List<LdAccommodationEntity> getAllAccommodations(){
        return ldAccommodationRepository.findAll();
    }

    public void InsertAccommodation(LdAccommodationEntity ldAccommodationEntity){
        this.ldAccommodationRepository.save(ldAccommodationEntity);
    }
}
