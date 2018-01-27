package Classes.service;

import Classes.dbEntity.LdAccommodationEntity;
import Classes.dbEntity.LdAccommodationRoomEntity;
import Classes.repository.LdAccommodationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationRoomServices
{

	@Autowired
	private LdAccommodationRoomRepository ldAccommodationRoomRepository;

	public List<LdAccommodationRoomEntity> getAllAllocations()
	{
		return ldAccommodationRoomRepository.findAll();
	}

	public LdAccommodationRoomEntity InsertAllocation( LdAccommodationRoomEntity ldAccommodationRoomEntity )
	{
		return this.ldAccommodationRoomRepository.save( ldAccommodationRoomEntity );
	}
}
