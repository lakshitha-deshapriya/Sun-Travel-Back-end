package Classes.service;

import Classes.dbEntity.LdRoomTypeEntity;
import Classes.repository.LdRoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomTypeServices {

    @Autowired
    private LdRoomTypeRepository ldRoomTypeRepository;

    public List<LdRoomTypeEntity> getAllRoomTypes(){
        return ldRoomTypeRepository.findAll();
    }

    public void InsertRoomType(LdRoomTypeEntity ldRoomTypeEntity){
        this.ldRoomTypeRepository.save(ldRoomTypeEntity);
    }

    public List<LdRoomTypeEntity> getRoomTypeforAvailability(Date date){
        return this.ldRoomTypeRepository.findByLdContractsByContractIdEndDateGreaterThanEqualAndLdContractsByContractIdStartDateLessThanEqual(date,date);
    }
}
