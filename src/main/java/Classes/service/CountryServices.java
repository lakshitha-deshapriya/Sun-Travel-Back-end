package Classes.service;

import Classes.dbEntity.LdCountryEntity;
import Classes.repository.LdCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServices {

    @Autowired
    private LdCountryRepository ldCountryRepository;

    public List<LdCountryEntity> getAllCountry(){
        return ldCountryRepository.findAll();
    }

    public void InsertCountry(LdCountryEntity ldCountryEntity){
        this.ldCountryRepository.save(ldCountryEntity);
    }
}
