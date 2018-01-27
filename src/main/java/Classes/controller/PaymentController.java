package Classes.controller;

import Classes.dbEntity.LdPaymentEntity;
import Classes.service.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "*")
public class PaymentController
{

	@Autowired
	private PaymentServices paymentServices;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<LdPaymentEntity> getAllPayments()
	{
		return this.paymentServices.getAllPayments();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void InsertPayment( @RequestBody LdPaymentEntity ldPaymentEntity )
	{
		this.paymentServices.InsertPayment( ldPaymentEntity );
	}
}
