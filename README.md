# Micronaut websocket path parsing


## Run server
```shell
./gradlew run
```

## Test client

```shell
curl --include \
     --no-buffer \
     --header "Connection: Upgrade" \
     --header "Upgrade: websocket" \
     --header "Host: localhost:8080" \
     --header "Origin: http://localhost:8080" \
     --header "Sec-WebSocket-Key: SGVsbG8sIHdvcmxkIQ==" \
     --header "Sec-WebSocket-Version: 13" \
     http://localhost:8080/\\{test\\}
```

## Exception (uncaught)

```text
21:06:18.458 [default-nioEventLoopGroup-1-4] ERROR i.m.h.s.netty.RoutingInBoundHandler - Micronaut Server Error - No request state present. Cause: Illegal character in path at index 1: /{test}
java.lang.IllegalArgumentException: Illegal character in path at index 1: /{test}
        at java.base/java.net.URI.create(URI.java:932)
        at io.micronaut.http.netty.AbstractNettyHttpRequest.<init>(AbstractNettyHttpRequest.java:71)
        at io.micronaut.http.server.netty.NettyHttpRequest.<init>(NettyHttpRequest.java:191)
        at io.micronaut.http.server.netty.websocket.NettyServerWebSocketUpgradeHandler.accept(NettyServerWebSocketUpgradeHandler.java:138)
        at io.micronaut.http.server.netty.handler.PipeliningServerHandler$MessageInboundHandler.read(PipeliningServerHandler.java:357)
        at io.micronaut.http.server.netty.handler.PipeliningServerHandler.channelRead(PipeliningServerHandler.java:206)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelRead(ChannelInboundHandlerAdapter.java:93)
        at io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.onHttpRequestChannelRead(WebSocketServerExtensionHandler.java:160)
        at io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.channelRead(WebSocketServerExtensionHandler.java:83)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
        at io.netty.handler.codec.MessageToMessageCodec.channelRead(MessageToMessageCodec.java:111)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.channel.ChannelInboundHandlerAdapter.channelRead(ChannelInboundHandlerAdapter.java:93)
        at io.netty.handler.codec.http.HttpServerKeepAliveHandler.channelRead(HttpServerKeepAliveHandler.java:64)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:436)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:346)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:318)
        at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:251)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.handler.timeout.IdleStateHandler.channelRead(IdleStateHandler.java:286)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
        at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1410)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:440)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:919)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:166)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:788)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:724)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:650)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:562)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.net.URISyntaxException: Illegal character in path at index 1: /{test}
        at java.base/java.net.URI$Parser.fail(URI.java:2995)
        at java.base/java.net.URI$Parser.checkChars(URI.java:3166)
        at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3248)
        at java.base/java.net.URI$Parser.parse(URI.java:3207)
        at java.base/java.net.URI.<init>(URI.java:645)
        at java.base/java.net.URI.create(URI.java:930)
        ... 52 common frames omitted
```

## Wireshark / tcpdump

```shell
43	26.386912	::1	::1	HTTP	299	GET /{test} HTTP/1.1 
44	26.386921	::1	::1	TCP	76	8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2342995533 TSecr=4162505409
53	86.388863	::1	::1	TCP	64	[TCP Keep-Alive] 62694 → 8080 [ACK] Seq=223 Ack=1 Win=407744 Len=0
54	86.388966	::1	::1	TCP	76	[TCP Keep-Alive ACK] 8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343055534 TSecr=4162505409
55	146.390245	::1	::1	TCP	64	[TCP Keep-Alive] 62694 → 8080 [ACK] Seq=223 Ack=1 Win=407744 Len=0
56	146.390331	::1	::1	TCP	76	[TCP Keep-Alive ACK] 8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343115535 TSecr=4162505409
73	206.390792	::1	::1	TCP	64	[TCP Keep-Alive] 62694 → 8080 [ACK] Seq=223 Ack=1 Win=407744 Len=0
74	206.390821	::1	::1	TCP	76	[TCP Keep-Alive ACK] 8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343175535 TSecr=4162505409
75	266.391481	::1	::1	TCP	64	[TCP Keep-Alive] 62694 → 8080 [ACK] Seq=223 Ack=1 Win=407744 Len=0
76	266.391585	::1	::1	TCP	76	[TCP Keep-Alive ACK] 8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343235535 TSecr=4162505409
77	326.392516	::1	::1	TCP	64	[TCP Keep-Alive] 62694 → 8080 [ACK] Seq=223 Ack=1 Win=407744 Len=0
78	326.392587	::1	::1	TCP	76	[TCP Keep-Alive ACK] 8080 → 62694 [ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343295535 TSecr=4162505409
79	326.394213	::1	::1	TCP	76	8080 → 62694 [FIN, ACK] Seq=1 Ack=224 Win=407552 Len=0 TSval=2343295537 TSecr=4162505409
80	326.394270	::1	::1	TCP	76	62694 → 8080 [ACK] Seq=224 Ack=2 Win=407744 Len=0 TSval=4162805413 TSecr=2343295537
81	326.394334	::1	::1	TCP	76	62694 → 8080 [FIN, ACK] Seq=224 Ack=2 Win=407744 Len=0 TSval=4162805413 TSecr=2343295537
82	326.394402	::1	::1	TCP	76	8080 → 62694 [ACK] Seq=2 Ack=225 Win=407552 Len=0 TSval=2343295537 TSecr=4162805413
```