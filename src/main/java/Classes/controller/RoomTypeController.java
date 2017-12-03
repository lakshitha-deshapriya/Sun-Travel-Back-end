package Classes.controller;

import Classes.dbEntity.LdRoomTypeEntity;
import Classes.service.RoomTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("roomtype")
@CrossOrigin(origins = "*")
public class RoomTypeController {

    @Autowired
    private RoomTypeServices roomTypeServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdRoomTypeEntity> getAllContracts(){
        return this.roomTypeServices.getAllRoomTypes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertCountry(@RequestBody LdRoomTypeEntity ldRoomTypeEntity){
        this.roomTypeServices.InsertRoomType(ldRoomTypeEntity);
    }
}
