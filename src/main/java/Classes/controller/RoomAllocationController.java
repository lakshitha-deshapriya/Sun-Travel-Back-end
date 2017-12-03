package Classes.controller;

import Classes.dbEntity.LdAccommodationRoomEntity;
import Classes.service.AccommodationRoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("allocation")
@CrossOrigin(origins = "*")
public class RoomAllocationController {

    @Autowired
    private AccommodationRoomServices accommodationRoomServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdAccommodationRoomEntity> getAllAllocations(){
        return this.accommodationRoomServices.getAllAllocations();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertAllocation(@RequestBody LdAccommodationRoomEntity ldAccommodationRoomEntity){
        this.accommodationRoomServices.InsertAllocation(ldAccommodationRoomEntity);
    }
}
