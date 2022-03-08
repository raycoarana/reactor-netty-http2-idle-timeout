# reactor-netty HTTP/1.1 & HTTP/2 idle-timeout

When client only supports HTTP/1.1 and an idle-timeout is set in server, `HttpTrafficHandler` fails to attach `IdleTimeoutHandler` in the `operationComplete` method, as neither `httpCodec` nor `h2cUpgradeHandler` are in the pipeline.
