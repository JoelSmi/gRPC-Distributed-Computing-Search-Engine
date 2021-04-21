package SearchEngineServerRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SearchEngine.proto")
public final class EngineServiceGrpc {

  private EngineServiceGrpc() {}

  public static final String SERVICE_NAME = "EngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.URLRequest,
      SearchEngineServerRPC.SearchEngine.ValidURL> getRequestSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestSite",
      requestType = SearchEngineServerRPC.SearchEngine.URLRequest.class,
      responseType = SearchEngineServerRPC.SearchEngine.ValidURL.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.URLRequest,
      SearchEngineServerRPC.SearchEngine.ValidURL> getRequestSiteMethod() {
    io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.URLRequest, SearchEngineServerRPC.SearchEngine.ValidURL> getRequestSiteMethod;
    if ((getRequestSiteMethod = EngineServiceGrpc.getRequestSiteMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getRequestSiteMethod = EngineServiceGrpc.getRequestSiteMethod) == null) {
          EngineServiceGrpc.getRequestSiteMethod = getRequestSiteMethod = 
              io.grpc.MethodDescriptor.<SearchEngineServerRPC.SearchEngine.URLRequest, SearchEngineServerRPC.SearchEngine.ValidURL>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EngineService", "RequestSite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchEngineServerRPC.SearchEngine.URLRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchEngineServerRPC.SearchEngine.ValidURL.getDefaultInstance()))
                  .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("RequestSite"))
                  .build();
          }
        }
     }
     return getRequestSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.KeywordRequest,
      SearchEngineServerRPC.SearchEngine.URLs> getSearchRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchRequest",
      requestType = SearchEngineServerRPC.SearchEngine.KeywordRequest.class,
      responseType = SearchEngineServerRPC.SearchEngine.URLs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.KeywordRequest,
      SearchEngineServerRPC.SearchEngine.URLs> getSearchRequestMethod() {
    io.grpc.MethodDescriptor<SearchEngineServerRPC.SearchEngine.KeywordRequest, SearchEngineServerRPC.SearchEngine.URLs> getSearchRequestMethod;
    if ((getSearchRequestMethod = EngineServiceGrpc.getSearchRequestMethod) == null) {
      synchronized (EngineServiceGrpc.class) {
        if ((getSearchRequestMethod = EngineServiceGrpc.getSearchRequestMethod) == null) {
          EngineServiceGrpc.getSearchRequestMethod = getSearchRequestMethod = 
              io.grpc.MethodDescriptor.<SearchEngineServerRPC.SearchEngine.KeywordRequest, SearchEngineServerRPC.SearchEngine.URLs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "EngineService", "SearchRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchEngineServerRPC.SearchEngine.KeywordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchEngineServerRPC.SearchEngine.URLs.getDefaultInstance()))
                  .setSchemaDescriptor(new EngineServiceMethodDescriptorSupplier("SearchRequest"))
                  .build();
          }
        }
     }
     return getSearchRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EngineServiceStub newStub(io.grpc.Channel channel) {
    return new EngineServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EngineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EngineServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EngineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EngineServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EngineServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestSite(SearchEngineServerRPC.SearchEngine.URLRequest request,
        io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.ValidURL> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestSiteMethod(), responseObserver);
    }

    /**
     */
    public void searchRequest(SearchEngineServerRPC.SearchEngine.KeywordRequest request,
        io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.URLs> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestSiteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SearchEngineServerRPC.SearchEngine.URLRequest,
                SearchEngineServerRPC.SearchEngine.ValidURL>(
                  this, METHODID_REQUEST_SITE)))
          .addMethod(
            getSearchRequestMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                SearchEngineServerRPC.SearchEngine.KeywordRequest,
                SearchEngineServerRPC.SearchEngine.URLs>(
                  this, METHODID_SEARCH_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class EngineServiceStub extends io.grpc.stub.AbstractStub<EngineServiceStub> {
    private EngineServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EngineServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EngineServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestSite(SearchEngineServerRPC.SearchEngine.URLRequest request,
        io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.ValidURL> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchRequest(SearchEngineServerRPC.SearchEngine.KeywordRequest request,
        io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.URLs> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EngineServiceBlockingStub extends io.grpc.stub.AbstractStub<EngineServiceBlockingStub> {
    private EngineServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EngineServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EngineServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public SearchEngineServerRPC.SearchEngine.ValidURL requestSite(SearchEngineServerRPC.SearchEngine.URLRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestSiteMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<SearchEngineServerRPC.SearchEngine.URLs> searchRequest(
        SearchEngineServerRPC.SearchEngine.KeywordRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EngineServiceFutureStub extends io.grpc.stub.AbstractStub<EngineServiceFutureStub> {
    private EngineServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EngineServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EngineServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EngineServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SearchEngineServerRPC.SearchEngine.ValidURL> requestSite(
        SearchEngineServerRPC.SearchEngine.URLRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestSiteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_SITE = 0;
  private static final int METHODID_SEARCH_REQUEST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EngineServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EngineServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_SITE:
          serviceImpl.requestSite((SearchEngineServerRPC.SearchEngine.URLRequest) request,
              (io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.ValidURL>) responseObserver);
          break;
        case METHODID_SEARCH_REQUEST:
          serviceImpl.searchRequest((SearchEngineServerRPC.SearchEngine.KeywordRequest) request,
              (io.grpc.stub.StreamObserver<SearchEngineServerRPC.SearchEngine.URLs>) responseObserver);
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

  private static abstract class EngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SearchEngineServerRPC.SearchEngine.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EngineService");
    }
  }

  private static final class EngineServiceFileDescriptorSupplier
      extends EngineServiceBaseDescriptorSupplier {
    EngineServiceFileDescriptorSupplier() {}
  }

  private static final class EngineServiceMethodDescriptorSupplier
      extends EngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EngineServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EngineServiceFileDescriptorSupplier())
              .addMethod(getRequestSiteMethod())
              .addMethod(getSearchRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
