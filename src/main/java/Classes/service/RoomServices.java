package Classes.service;

import Classes.dbEntity.LdRoomsEntity;
import Classes.repository.LdRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServices {

    @Autowired
    private LdRoomsRepository ldRoomsRepository;

    public List<LdRoomsEntity> getAllRooms(){
        return ldRoomsRepository.findAll();
    }

    public void InsertRoom(LdRoomsEntity ldRoomsEntity){
        this.ldRoomsRepository.save(ldRoomsEntity);
    }
}
