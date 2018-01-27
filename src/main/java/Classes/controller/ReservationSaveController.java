package Classes.controller;

import Classes.dbEntity.*;
import Classes.modelEntity.ReservationEntity;
import Classes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("reservation")
@CrossOrigin(origins = "*")
public class ReservationSaveController
{

	@Autowired
	private CountryServices countryServices;

	@Autowired
	private CityServices cityServices;

	@Autowired
	private AddressServices addressServices;

	@Autowired
	private RoomTypeServices roomTypeServices;

	@Autowired
	private CustomerServices customerServices;

	@Autowired
	private AccommodationServices accommodationServices;

	@Autowired
	private AvailabilityServices availabilityServices;

	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public Boolean InsertReservation( @RequestBody ReservationEntity[] reservationEntities ) throws ParseException
	{
		boolean msg = true;
		for ( ReservationEntity reservationEntity : reservationEntities )
		{
			if ( msg )
			{
				ReservationEntity re = reservationEntity;

				System.out.println(re.getCheckindate());

				LdCountryEntity ldCountryEntity = this.getCountry( re.getCountry() );

				LdCityEntity ldCityEntity = this.saveOrReturnCity( re.getCity(), ldCountryEntity );

				LdAddressEntity ldAddressEntity = this.saveOrReturnAddress( re.getPbox(), re.getRegion(), Long.parseLong( re.getZipcode() ), ldCityEntity );

				LdCustomerEntity ldCustomerEntity = this.saveOrReturnCustomer( re.getFname(), re.getLname(), re.getPhone(), re.getEmail(), ldAddressEntity );

				LdRoomTypeEntity ldRoomTypeEntity = this.getRoomTypeByName( re.getRoomtype() );

				if ( ldCustomerEntity != null && ldRoomTypeEntity != null )
				{
					LdAccommodationEntity ldAccommodationEntity = this.saveReservation( re.getCheckindate(), ldCustomerEntity );
					if ( ldAccommodationEntity != null )
					{
						LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity = this.updateAvailability( ldRoomTypeEntity, re.getCheckindate(), re.getNoofrooms(), re.getNoofnights() );
						if ( ldRoomtypeAvailabilityEntity == null )
						{
							this.accommodationServices.deleteAccommodation( ldAccommodationEntity );
							msg = false;
						}
					}
					else
					{
						msg = false;
					}
				}
				else
				{
					msg = false;
				}
			}
		}
		return msg;
	}

	//Get the country object by countryName
	private LdCountryEntity getCountry( String countryName )
	{
		return countryServices.getCountryByCountryName( countryName );
	}

	//check the city object and save or return it
	private LdCityEntity saveOrReturnCity( String cityName, LdCountryEntity ldCountryEntity )
	{
		return this.cityServices.saveOrReturnCity( cityName, ldCountryEntity );
	}

	//check the address object and save or return it
	private LdAddressEntity saveOrReturnAddress( String pbox, String region, Long zipcode, LdCityEntity ldCityEntity )
	{
		return this.addressServices.saveOrReturnAddress( pbox, region, zipcode, ldCityEntity );
	}

	//get Roomtype Object
	private LdRoomTypeEntity getRoomTypeByName( String roomType )
	{
		return this.roomTypeServices.getRoomTypeByName( roomType );
	}

	//check the customer object and save or return it
	private LdCustomerEntity saveOrReturnCustomer( String fname, String lname, String phoneNumber, String email, LdAddressEntity ldAddressEntity )
	{
		LdCustomerEntity ldCustomerEntity = this.customerServices.getCustomerByData( fname, lname, ldAddressEntity );
		if ( ldCustomerEntity == null )
		{
			LdCustomerEntity customerEntitynew = new LdCustomerEntity();

			customerEntitynew.setfName( fname );
			customerEntitynew.setlName( lname );
			customerEntitynew.setPhoneNumber( phoneNumber );
			customerEntitynew.setEmail( email );
			customerEntitynew.setLdAddressByAddressId( ldAddressEntity );

			return this.customerServices.InsertCustomer( customerEntitynew );
		}
		else
		{
			return ldCustomerEntity;
		}
	}

	//Save to accommodation
	private LdAccommodationEntity saveReservation( String date, LdCustomerEntity ldCustomerEntity ) throws ParseException
	{
		try
		{
			LdAccommodationEntity ldAccommodationEntitynew = new LdAccommodationEntity();

			SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd" );
			java.util.Date datetemp = sdf1.parse( date );
			java.sql.Date datenew = new java.sql.Date( datetemp.getTime() );

			ldAccommodationEntitynew.setLdCustomerByCustomerId( ldCustomerEntity );
			ldAccommodationEntitynew.setCheckInDate( datenew );

			return this.accommodationServices.InsertAccommodation( ldAccommodationEntitynew );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return null;
		}

	}

	//update availability
	private LdRoomtypeAvailabilityEntity updateAvailability( LdRoomTypeEntity ldRoomTypeEntity, String date, Long noOfRoooms, Long noOfNights ) throws ParseException
	{
		try
		{
			LdRoomtypeAvailabilityEntity entity = new LdRoomtypeAvailabilityEntity();

			entity.setAvailableDate( java.sql.Date.valueOf( date ) );
			entity.setAvailableNoRooms( noOfRoooms );
			entity.setLdRoomTypeByTypeId( ldRoomTypeEntity );

			return this.availabilityServices.updateAvailability( entity );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return null;
		}

	}

}
