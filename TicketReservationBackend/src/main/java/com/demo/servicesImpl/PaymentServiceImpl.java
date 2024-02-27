package com.demo.servicesImpl;

import org.springframework.stereotype.Service;

import com.demo.entity.Payments;
import com.demo.repository.PaymentRepository;
import com.demo.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payments savePayments(Payments payments) {
        return paymentRepository.save(payments);
    }

    @Override
    public Payments showPaymentDetails(String payerName) {
        return paymentRepository.findByPayerName(payerName);
    }
}