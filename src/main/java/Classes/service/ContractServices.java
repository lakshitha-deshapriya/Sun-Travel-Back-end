package Classes.service;

import Classes.dbEntity.LdContractsEntity;
import Classes.dbEntity.LdHotelEntity;
import Classes.repository.LdContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ContractServices
{

	@Autowired
	private LdContractsRepository ldContractsRepository;

	public List<LdContractsEntity> getAllContracts()
	{
		return ldContractsRepository.findAll();
	}

	public LdContractsEntity InsertContract( LdContractsEntity ldContractsEntity )
	{
		return this.ldContractsRepository.save( ldContractsEntity );
	}

	public LdContractsEntity getContractByHotelNameAndDate( LdHotelEntity ldHotelEntity, Date startdate, Date enddate )
	{
		return this.ldContractsRepository.findByLdHotelByHotelIdAndStartDateAndEndDate( ldHotelEntity, startdate, enddate );
	}
}
