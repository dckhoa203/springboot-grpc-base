package com.example.proxy;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: proxy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProxyServiceGrpc {

  private ProxyServiceGrpc() {}

  public static final String SERVICE_NAME = "proxy.ProxyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proxy.PartnerOrderRequest,
      com.example.proxy.PartnerOrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = com.example.proxy.PartnerOrderRequest.class,
      responseType = com.example.proxy.PartnerOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proxy.PartnerOrderRequest,
      com.example.proxy.PartnerOrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<com.example.proxy.PartnerOrderRequest, com.example.proxy.PartnerOrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = ProxyServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (ProxyServiceGrpc.class) {
        if ((getPlaceOrderMethod = ProxyServiceGrpc.getPlaceOrderMethod) == null) {
          ProxyServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod =
              io.grpc.MethodDescriptor.<com.example.proxy.PartnerOrderRequest, com.example.proxy.PartnerOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PlaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proxy.PartnerOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proxy.PartnerOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProxyServiceMethodDescriptorSupplier("PlaceOrder"))
              .build();
        }
      }
    }
    return getPlaceOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProxyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProxyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProxyServiceStub>() {
        @java.lang.Override
        public ProxyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProxyServiceStub(channel, callOptions);
        }
      };
    return ProxyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProxyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProxyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProxyServiceBlockingStub>() {
        @java.lang.Override
        public ProxyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProxyServiceBlockingStub(channel, callOptions);
        }
      };
    return ProxyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProxyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProxyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProxyServiceFutureStub>() {
        @java.lang.Override
        public ProxyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProxyServiceFutureStub(channel, callOptions);
        }
      };
    return ProxyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProxyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void placeOrder(com.example.proxy.PartnerOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.proxy.PartnerOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlaceOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.proxy.PartnerOrderRequest,
                com.example.proxy.PartnerOrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class ProxyServiceStub extends io.grpc.stub.AbstractAsyncStub<ProxyServiceStub> {
    private ProxyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProxyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProxyServiceStub(channel, callOptions);
    }

    /**
     */
    public void placeOrder(com.example.proxy.PartnerOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.proxy.PartnerOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProxyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProxyServiceBlockingStub> {
    private ProxyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProxyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProxyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proxy.PartnerOrderResponse placeOrder(com.example.proxy.PartnerOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProxyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProxyServiceFutureStub> {
    private ProxyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProxyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProxyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proxy.PartnerOrderResponse> placeOrder(
        com.example.proxy.PartnerOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProxyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProxyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((com.example.proxy.PartnerOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.example.proxy.PartnerOrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProxyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProxyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proxy.Proxy.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProxyService");
    }
  }

  private static final class ProxyServiceFileDescriptorSupplier
      extends ProxyServiceBaseDescriptorSupplier {
    ProxyServiceFileDescriptorSupplier() {}
  }

  private static final class ProxyServiceMethodDescriptorSupplier
      extends ProxyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProxyServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProxyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProxyServiceFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
