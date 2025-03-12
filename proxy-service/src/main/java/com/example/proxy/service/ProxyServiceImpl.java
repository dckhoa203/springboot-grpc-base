package com.example.proxy.service;

import com.example.proxy.PartnerOrderRequest;
import com.example.proxy.PartnerOrderResponse;
import com.example.proxy.ProxyServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@GrpcService
public class ProxyServiceImpl extends ProxyServiceGrpc.ProxyServiceImplBase {
    private static final Logger logger = LogManager.getLogger(ProxyServiceImpl.class);

    @Override
    public void placeOrder(PartnerOrderRequest request, StreamObserver<PartnerOrderResponse> responseObserver) {
        logger.info("Received order request for user: {} {}", request.getDenomination(), request.getQuantity());

        PartnerOrderResponse response = PartnerOrderResponse.newBuilder()
                .setPartnerOrderId("partner-" + System.currentTimeMillis())
                .setStatus("SUCCESS")
                .build();

        logger.info("Response partner order: {} {}", response.getPartnerOrderId(), response.getStatus());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
