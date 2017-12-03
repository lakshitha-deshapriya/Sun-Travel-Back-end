package Classes.controller;

import Classes.dbEntity.LdAddressEntity;
import Classes.service.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressServices addressServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdAddressEntity> getAllAddress(){
        return addressServices.getAllAddresses();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertAddressData(@RequestBody LdAddressEntity ldAddressEntity){
        this.addressServices.insertAddress(ldAddressEntity);
    }
}
