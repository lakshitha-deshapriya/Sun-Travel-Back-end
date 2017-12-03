package Classes.controller;

import Classes.dbEntity.LdContractsEntity;
import Classes.service.ContractServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("contracts")
@CrossOrigin(origins = "*")
public class ContractController {

    @Autowired
    private ContractServices contractServices;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<LdContractsEntity> getAllContracts(){
        return this.contractServices.getAllContracts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void InsertCountry(@RequestBody LdContractsEntity ldContractsEntity){
        this.contractServices.InsertContract(ldContractsEntity);
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<LdContractsEntity> getContractsByHotelName(@RequestBody String hotelName){
        JSONObject json = new JSONObject(hotelName);
        return contractServices.getContactByHotelName(json.getString("hotelName"));
    }
}
