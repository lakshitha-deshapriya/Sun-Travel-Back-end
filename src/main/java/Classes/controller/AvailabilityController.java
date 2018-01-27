package Classes.controller;

import Classes.dbEntity.LdHotelEntity;
import Classes.dbEntity.LdRoomTypeEntity;
import Classes.dbEntity.LdRoomtypeAvailabilityEntity;
import Classes.service.AvailabilityServices;
import Classes.service.HotelServices;
import Classes.service.RoomTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.time.LocalDate;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@RestController
@RequestMapping("availability")
@CrossOrigin(origins = "*")
public class AvailabilityController
{

	@Autowired
	private AvailabilityServices availabilityServices;

	@Autowired
	private RoomTypeServices roomTypeServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdRoomtypeAvailabilityEntity> getAllAvailabilities()
	{
		return this.availabilityServices.getAllAvailabilities();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertAvailability( @RequestBody LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity )
	{
		this.availabilityServices.InsertRoomAvailability( ldRoomtypeAvailabilityEntity );
	}

	@RequestMapping(value = "/search/{availableDate}/{noNights}/{noRooms}/{noAdults}", method = RequestMethod.GET)
	public ArrayList<Object> getAvailability( @PathVariable String availableDate, @PathVariable Long noNights, @PathVariable Long noRooms, @PathVariable Long noAdults ) throws ParseException
	{
		ArrayList<Object> results = new ArrayList<>();

		ArrayList<LdHotelEntity> AvailHotels = new ArrayList<>();

		SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd" );
		java.util.Date date = sdf1.parse( availableDate );

		if ( !this.availabilityServices.getAvailabilityCount( date ).equals( this.roomTypeServices.getRoomTypeCount( date ) ) )
		{
			this.populateAvailability( date, availableDate );
		}

		Collection<LdRoomtypeAvailabilityEntity> ldRoomtypeAvailabilityEntities = this.availabilityServices.getAvailabilityByDate( date );
		if ( noNights.equals( 1L ) )
		{
			this.checkAvailability( noRooms, noAdults, date, ldRoomtypeAvailabilityEntities );
		}
		else if ( !noNights.equals( 1L ) )
		{

			this.checkAvailability( noRooms, noAdults, date, ldRoomtypeAvailabilityEntities );

			List<LdRoomtypeAvailabilityEntity> ldRoomtypeAvailabilityEntities1;

			for ( int i = 1; i < noNights; i++ )
			{
				Format sdf2 = new SimpleDateFormat( "yyyy-MM-dd" );
				java.util.Date newdate = this.addDays( date, i );
				String dateString = sdf2.format( newdate );

				if ( !this.availabilityServices.getAvailabilityCount( newdate ).equals( this.roomTypeServices.getRoomTypeCount( newdate ) ) )
				{
					this.populateAvailability( newdate, dateString );
				}

				Collection<LdRoomtypeAvailabilityEntity> entitiesForNewDate = this.availabilityServices.getAvailabilityByDate( newdate );

				this.checkAvailability( noRooms, noAdults, newdate, entitiesForNewDate );

				Iterator<LdRoomtypeAvailabilityEntity> it = ldRoomtypeAvailabilityEntities.iterator();

				while ( it.hasNext() )
				{
					boolean hasobject = false;
					LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity = it.next();

					for ( LdRoomtypeAvailabilityEntity entity : entitiesForNewDate )
					{
						if ( entity.getLdRoomTypeByTypeId().getTypeId() == ldRoomtypeAvailabilityEntity.getLdRoomTypeByTypeId().getTypeId() )
						{
							hasobject = true;
							if ( entity.getAvailableNoRooms() < ldRoomtypeAvailabilityEntity.getAvailableNoRooms() )
							{
								ldRoomtypeAvailabilityEntity.setAvailableNoRooms( entity.getAvailableNoRooms() );
							}
						}
					}

					if ( !hasobject )
					{
						it.remove();
					}
				}

			}
		}

		for ( LdRoomtypeAvailabilityEntity entity : ldRoomtypeAvailabilityEntities )
		{
			try
			{
				if ( !AvailHotels.contains( entity.getLdRoomTypeByTypeId().getLdContractsByContractId().getLdHotelByHotelId() ) )
				{
					AvailHotels.add( entity.getLdRoomTypeByTypeId().getLdContractsByContractId().getLdHotelByHotelId() );
				}
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
		}

		results.add( ldRoomtypeAvailabilityEntities );
		results.add( AvailHotels );
		return results;
	}

	private Date addDays( Date date, int days )
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime( date );
		cal.add( Calendar.DATE, days );
		return cal.getTime();
	}

	private void populateAvailability( Date date, String availabledate )
	{
		Collection<LdRoomtypeAvailabilityEntity> ldRoomtypeAvailabilityEntities = this.availabilityServices.getAvailabilityByDate( date );

		if ( ldRoomtypeAvailabilityEntities.isEmpty() )
		{
			Collection<LdRoomTypeEntity> ldRoomTypeEntities = this.roomTypeServices.getRoomTypeforAvailability( date );

			for ( LdRoomTypeEntity entity : ldRoomTypeEntities )
			{
				this.insertToAvailability( entity, availabledate );
			}
		}
		else if ( !this.availabilityServices.getAvailabilityCount( date ).equals( this.roomTypeServices.getRoomTypeCount( date ) ) )
		{

			Collection<LdRoomTypeEntity> ldRoomTypeEntities = this.roomTypeServices.getRoomTypeforAvailability( date );

			for ( LdRoomTypeEntity entity : ldRoomTypeEntities )
			{
				if ( this.availabilityServices.getAvailabilityByRoomType( entity.getTypeId(), date ) == null )
				{
					this.insertToAvailability( entity, availabledate );
				}
			}
		}
	}

	private void insertToAvailability( LdRoomTypeEntity entity, String availabledate )
	{
		LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity = new LdRoomtypeAvailabilityEntity();
		ldRoomtypeAvailabilityEntity.setAvailableDate( java.sql.Date.valueOf( availabledate ) );
		ldRoomtypeAvailabilityEntity.setAvailableNoRooms( entity.getNoOfRooms() );
		ldRoomtypeAvailabilityEntity.setLdRoomTypeByTypeId( entity );

		this.availabilityServices.InsertRoomAvailability( ldRoomtypeAvailabilityEntity );
	}

	private void checkAvailability( Long noRooms, Long noAdults, Date date, Collection<LdRoomtypeAvailabilityEntity> ldRoomtypeAvailabilityEntities )
	{
		if ( !noRooms.equals( 0L ) )
		{
			Iterator<LdRoomtypeAvailabilityEntity> it = ldRoomtypeAvailabilityEntities.iterator();

			while ( it.hasNext() )
			{
				LdRoomtypeAvailabilityEntity ldRoomtypeAvailabilityEntity = it.next();

				if ( ldRoomtypeAvailabilityEntity.getAvailableNoRooms() < noRooms )
				{
					it.remove();
				}
			}
		}

		if ( !noAdults.equals( 0L ) )
		{
			if ( noRooms.equals( 0L ) )
			{
				Iterator<LdRoomtypeAvailabilityEntity> it = ldRoomtypeAvailabilityEntities.iterator();

				while ( it.hasNext() )
				{
					LdRoomtypeAvailabilityEntity entity = it.next();
					if ( entity.getAvailableNoRooms() * entity.getLdRoomTypeByTypeId().getMaxAdults() < noAdults )
					{
						it.remove();
					}
				}
			}
			else
			{
				Iterator<LdRoomtypeAvailabilityEntity> it = ldRoomtypeAvailabilityEntities.iterator();

				while ( it.hasNext() )
				{
					boolean rem = false;
					LdRoomtypeAvailabilityEntity entity = it.next();
					if ( entity.getAvailableNoRooms() * entity.getLdRoomTypeByTypeId().getMaxAdults() < noAdults )
					{
						rem = true;
					}
					if ( noRooms * entity.getLdRoomTypeByTypeId().getMaxAdults() < noAdults )
					{
						rem = true;
					}
					if ( rem )
					{
						it.remove();
					}
				}
			}
		}

	}

}
