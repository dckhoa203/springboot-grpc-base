package com.example.payment.service;

import com.example.payment.CheckBalanceRequest;
import com.example.payment.CheckBalanceResponse;
import com.example.payment.PaymentServiceGrpc;
import com.example.payment.repository.UserBalanceRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@GrpcService
public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {
    private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class);

    @Autowired
    UserBalanceRepository userBalanceRepository;

    @Override
    public void checkBalance(CheckBalanceRequest request, StreamObserver<CheckBalanceResponse> responseStreamObserver) {
        String userId = request.getUserId();
        logger.info("Received order request for user: {}", userId);

        BigDecimal requestAmount = BigDecimal.valueOf(request.getAmount());
        BigDecimal balance = userBalanceRepository.getBalance(userId);
        logger.info("getBalance: {} {}", userId, balance);

        boolean sufficient = balance != null && balance.compareTo(requestAmount) >= 0;
        CheckBalanceResponse response = CheckBalanceResponse.newBuilder()
                .setSufficient(sufficient)
                .build();

        logger.info("Response call proxy: {}", response.getSufficient());

        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
