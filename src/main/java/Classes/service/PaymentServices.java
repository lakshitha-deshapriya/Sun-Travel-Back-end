package Classes.service;

import Classes.dbEntity.LdPaymentEntity;
import Classes.repository.LdPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {

    @Autowired
    private LdPaymentRepository ldPaymentRepository;

    public List<LdPaymentEntity> getAllPayments(){
        return ldPaymentRepository.findAll();
    }

    public void InsertPayment(LdPaymentEntity ldPaymentEntity){
        this.ldPaymentRepository.save(ldPaymentEntity);
    }
}
