package Classes.controller;

import Classes.dbEntity.*;
import Classes.modelEntity.AddContractEntity;
import Classes.modelEntity.ContractTable;
import Classes.modelEntity.MultipleRoomType;
import Classes.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("contracts")
@CrossOrigin(origins = "*")
public class ContractController
{

	@Autowired
	private CountryServices countryServices;

	@Autowired
	private CityServices cityServices;

	@Autowired
	private AddressServices addressServices;

	@Autowired
	private ContractServices contractServices;

	@Autowired
	private HotelServices hotelServices;

	@Autowired
	private RoomTypeServices roomTypeServices;

	ReservationSaveController rsc = new ReservationSaveController();

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdContractsEntity> getAllContracts()
	{
		return this.contractServices.getAllContracts();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertCountry( @RequestBody LdContractsEntity ldContractsEntity )
	{
		this.contractServices.InsertContract( ldContractsEntity );
	}

	@RequestMapping(value = "tabledata", method = RequestMethod.GET)
	public ArrayList<ContractTable> getContractForTable()
	{
		ArrayList<ContractTable> results = new ArrayList<>();

		Collection<LdContractsEntity> ldContractsEntities = this.contractServices.getAllContracts();

		for ( LdContractsEntity entity : ldContractsEntities )
		{
			ContractTable ct = new ContractTable();
			ct.setHotelName( entity.getLdHotelByHotelId().getHotelName() );
			ct.setStartDate( entity.getStartDate() );
			ct.setEndDate( entity.getEndDate() );
			ct.setContractId( entity.getContractId() );

			ArrayList<LdRoomTypeEntity> ldRoomTypeEntities = this.roomTypeServices.getRoomTypeByContract( entity );
			for ( LdRoomTypeEntity rtentity : ldRoomTypeEntities )
			{
				if ( ct.getRoomTypes() == null )
				{
					ct.setRoomTypes( rtentity.getType() );
				}
				else
				{
					ct.setRoomTypes( ct.getRoomTypes() + ", " + rtentity.getType() );
				}
			}
			results.add( ct );
		}
		return results;
	}

	@RequestMapping(value = "savecontract", method = RequestMethod.POST)
	public String saveContract( @RequestBody AddContractEntity[] addContractEntities ) throws ParseException
	{
		boolean success = true;
		String msg;
		for ( AddContractEntity addContractEntity : addContractEntities )
		{
			try
			{
				AddContractEntity ace = addContractEntity;
				//String msg;

				SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd" );
				java.util.Date tempstartdate = sdf1.parse( ace.getStartDate() );
				java.util.Date tempenddate = sdf1.parse( ace.getEndDate() );
				java.sql.Date startdatenew = new java.sql.Date( tempstartdate.getTime() );
				java.sql.Date enddatenew = new java.sql.Date( tempenddate.getTime() );

				LdCountryEntity ldCountryEntity = this.countryServices.getCountryByCountryName( ace.getCountry() );

				LdCityEntity ldCityEntity = this.cityServices.saveOrReturnCity( ace.getCity(), ldCountryEntity );

				LdAddressEntity ldAddressEntity = this.addressServices.saveOrReturnAddress( ace.getPbox(), ace.getRegion(), Long.parseLong( ace.getZipcode() ), ldCityEntity );

				LdHotelEntity ldHotelEntity = this.saveOrReturnHotel( ace.getHotelName(), ace.getDescription(), ldAddressEntity );

				LdContractsEntity ldContractsEntity = this.saveOrReturnContract( startdatenew, enddatenew, ldHotelEntity );

				this.saveRoomType( ace.getRoomType(), ace.getNoOfRooms(), ace.getMaxAdults(), ace.getPrice(), ace.getMarkup(), ldContractsEntity );
			}
			catch ( Exception e )
			{
				success = false;
			}

		}
		if ( success )
		{
			msg = "Successfully Saved";
		}
		else
		{
			msg = "Error occured when saving";
		}
		return msg;
	}

	//save or return hotel object
	public LdHotelEntity saveOrReturnHotel( String hotelName, String description, LdAddressEntity ldAddressEntity )
	{
		LdHotelEntity ldHotelEntity = this.hotelServices.getHotelByHotelNameAndAddress( hotelName, ldAddressEntity );
		if ( ldHotelEntity == null )
		{
			LdHotelEntity ldHotelEntitynew = new LdHotelEntity();

			ldHotelEntitynew.setHotelName( hotelName );
			ldHotelEntitynew.setDescription( description );
			ldHotelEntitynew.setLdAddressByAddressId( ldAddressEntity );

			return this.hotelServices.InsertHotel( ldHotelEntitynew );
		}
		else
		{
			return ldHotelEntity;
		}
	}

	//save oe return contract object
	public LdContractsEntity saveOrReturnContract( Date startDate, Date endDate, LdHotelEntity ldHotelEntity )
	{
		LdContractsEntity ldContractsEntity = this.contractServices.getContractByHotelNameAndDate( ldHotelEntity, startDate, endDate );
		if ( ldContractsEntity == null )
		{
			LdContractsEntity ldContractsEntitynew = new LdContractsEntity();

			ldContractsEntitynew.setLdHotelByHotelId( ldHotelEntity );
			ldContractsEntitynew.setStartDate( startDate );
			ldContractsEntitynew.setEndDate( endDate );

			return this.contractServices.InsertContract( ldContractsEntitynew );
		}
		else
		{
			return ldContractsEntity;
		}
	}

	//save roomtype
	public void saveRoomType( String roomType, Long noOfRooms, Long maxAdults, Double price, Double markup, LdContractsEntity ldContractsEntity )
	{
		LdRoomTypeEntity ldRoomTypeEntity = new LdRoomTypeEntity();

		ldRoomTypeEntity.setType( roomType );
		ldRoomTypeEntity.setNoOfRooms( noOfRooms );
		ldRoomTypeEntity.setMaxAdults( maxAdults );
		ldRoomTypeEntity.setPrice( price );
		ldRoomTypeEntity.setMarkup( markup );
		ldRoomTypeEntity.setLdContractsByContractId( ldContractsEntity );

		this.roomTypeServices.InsertRoomType( ldRoomTypeEntity );
	}
}
