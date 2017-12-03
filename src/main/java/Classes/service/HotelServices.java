package Classes.service;

import Classes.dbEntity.LdHotelEntity;
import Classes.repository.LdHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {

    @Autowired
    private LdHotelRepository ldHotelRepository;

    public List<LdHotelEntity> getAllHotels(){
        return ldHotelRepository.findAll();
    }

    public void InsertHotel(LdHotelEntity ldHotelEntity){
        this.ldHotelRepository.save(ldHotelEntity);
    }
}
