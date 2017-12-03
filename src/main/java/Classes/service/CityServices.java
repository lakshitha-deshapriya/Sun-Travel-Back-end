package Classes.service;

import Classes.dbEntity.LdCityEntity;
import Classes.repository.LdCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServices {

    @Autowired
    private LdCityRepository ldCityRepository;

    public List<LdCityEntity> getAllCities(){
        return ldCityRepository.findAll();
    }

    public void InsertCity(LdCityEntity ldCityEntity){
        this.ldCityRepository.save(ldCityEntity);
    }

}
