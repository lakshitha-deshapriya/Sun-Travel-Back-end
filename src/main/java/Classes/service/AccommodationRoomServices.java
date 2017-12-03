package Classes.service;

import Classes.dbEntity.LdAccommodationRoomEntity;
import Classes.repository.LdAccommodationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationRoomServices {

    @Autowired
    private LdAccommodationRoomRepository ldAccommodationRoomRepository;

    public List<LdAccommodationRoomEntity> getAllAllocations(){
        return ldAccommodationRoomRepository.findAll();
    }

    public void InsertAllocation(LdAccommodationRoomEntity ldAccommodationRoomEntity){
        this.ldAccommodationRoomRepository.save(ldAccommodationRoomEntity);
    }
}
