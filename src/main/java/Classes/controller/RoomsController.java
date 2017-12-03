package Classes.controller;

import Classes.dbEntity.LdRoomsEntity;
import Classes.service.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("rooms")
@CrossOrigin(origins = "*")
public class RoomsController {

    @Autowired
    private RoomServices roomServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdRoomsEntity> getAllRooms(){
        return this.roomServices.getAllRooms();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertRoom(@RequestBody LdRoomsEntity ldRoomsEntity){
        this.roomServices.InsertRoom(ldRoomsEntity);
    }
}
