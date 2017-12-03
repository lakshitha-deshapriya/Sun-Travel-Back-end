package Classes.controller;

import Classes.dbEntity.LdRoomTypeEntity;
import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import Classes.service.AvailabilityServices;
import Classes.service.HotelServices;
import Classes.service.RoomTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("availability")
@CrossOrigin(origins = "*")
public class AvailabilityController {

    @Autowired
    private AvailabilityServices availabilityServices;

    @Autowired
    private RoomTypeServices roomTypeServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdRoomtypeAvailabilityEntity> getAllAvailabilities(){
        return this.availabilityServices.getAllAvailabilities();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertAvailability(@RequestBody LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity){
        this.availabilityServices.InsertRoomAvailability(ldRoomtypeAvailabilityEntity);
    }

    @RequestMapping(value = "/search/{availableDate}/{noNights}/{noRooms}/{noAdults}", method = RequestMethod.GET)
    public Collection<LdRoomtypeAvailabilityEntity> getAvailability(@PathVariable String availableDate, @PathVariable Long noNights, @PathVariable Long noRooms, @PathVariable Long noAdults) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(availableDate);

        List<LdRoomtypeAvailabilityEntity> ldRoomtypeAvailabilityEntities=null;
        List<LdRoomTypeEntity> ldRoomTypeEntities = null;
        LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity=null;
//
//        System.out.println(date);
//        System.out.println(addDays(date,Integer.parseInt(noRooms.toString())));

        if ((noNights==0 && noRooms==0 && noAdults==0) || (noNights==0 && noRooms==0 && noAdults!=0)){
            System.out.println(1);

            ldRoomtypeAvailabilityEntities=this.availabilityServices.getAvailabilityByDate(date);

            if(ldRoomtypeAvailabilityEntities.isEmpty()){
                ldRoomTypeEntities=this.roomTypeServices.getRoomTypeforAvailability(date);

                for (LdRoomTypeEntity entity:ldRoomTypeEntities) {
                    ldRoomtypeAvailabilityEntity.setAvailabilityId(entity.getTypeId()*100);
                    ldRoomtypeAvailabilityEntity.setAvailableDate((java.sql.Date) date);
                    ldRoomtypeAvailabilityEntity.setAvailableNoRooms(entity.getNoOfRooms());
                    ldRoomtypeAvailabilityEntity.setLdRoomTypeByTypeId(entity);

                    ldRoomtypeAvailabilityEntities.add(ldRoomtypeAvailabilityEntity);
                }
            }
            System.out.println(ldRoomtypeAvailabilityEntities);

            return ldRoomtypeAvailabilityEntities;
        }else if (noNights ==0 && noRooms != 0 && noAdults == 0){
            System.out.println(2);
            return this.availabilityServices.getAvailabilityByDateAndNoRooms(date,noRooms);
        }else if (noNights ==0 && noRooms !=0 && noAdults !=0){
            System.out.println(3);
            return this.availabilityServices.getAvailabilityByNoRoomsAndNoAdults(noRooms,noAdults/noRooms, date);
        }else{
            return null;
        }
    }

    private Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days-1);
        return cal.getTime();
    }
}
