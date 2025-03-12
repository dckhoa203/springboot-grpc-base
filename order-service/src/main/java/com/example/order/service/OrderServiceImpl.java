package com.example.order.service;

import com.example.order.OrderRequest;
import com.example.order.OrderResponse;
import com.example.order.OrderServiceGrpc;
import com.example.payment.CheckBalanceRequest;
import com.example.payment.CheckBalanceResponse;
import com.example.payment.PaymentServiceGrpc;
import com.example.proxy.PartnerOrderRequest;
import com.example.proxy.PartnerOrderResponse;
import com.example.proxy.ProxyServiceGrpc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.util.UUID;

@GrpcService
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @GrpcClient("payment-service")
    private PaymentServiceGrpc.PaymentServiceBlockingStub paymentStub;

    @GrpcClient("proxy-service")
    private ProxyServiceGrpc.ProxyServiceBlockingStub proxyStub;

    @Override
    public void placeOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        logger.info("Received order request for user: {}", request.getUserId());

        int totalAmount = request.getDenomination() * request.getQuantity();

        CheckBalanceRequest checkReq = CheckBalanceRequest.newBuilder()
                .setUserId(request.getUserId())
                .setAmount(totalAmount)
                .build();
        CheckBalanceResponse checkRes = paymentStub.checkBalance(checkReq);

        if (!checkRes.getSufficient()) {
            logger.warn("Insufficient balance for user: {}", request.getUserId());
            OrderResponse response = OrderResponse.newBuilder()
                    .setOrderId("")
                    .setStatus("INSUFFICIENT_BALANCE")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        PartnerOrderRequest partnerReq = PartnerOrderRequest.newBuilder()
                .setDenomination(request.getDenomination())
                .setQuantity(request.getQuantity())
                .build();
        PartnerOrderResponse partnerRes = proxyStub.placeOrder(partnerReq);

        logger.info("Order placed successfully with ID: {}", "someOrderId");

        OrderResponse response = OrderResponse.newBuilder()
                .setOrderId(UUID.randomUUID().toString())
                .setStatus(partnerRes.getStatus())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}