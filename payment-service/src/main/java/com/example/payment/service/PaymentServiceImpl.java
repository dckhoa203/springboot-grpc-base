package com.example.payment.service;

import com.example.payment.CheckBalanceRequest;
import com.example.payment.CheckBalanceResponse;
import com.example.payment.PaymentServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@GrpcService
public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {
    private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class);

    @Override
    public void checkBalance(CheckBalanceRequest request, StreamObserver<CheckBalanceResponse> responseStreamObserver) {
        logger.info("Received order request for user: {}", request.getUserId());

        boolean sufficient = true;
        CheckBalanceResponse response = CheckBalanceResponse.newBuilder()
                .setSufficient(sufficient)
                .build();

        logger.info("Response call proxy: {}", response.getSufficient());

        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
