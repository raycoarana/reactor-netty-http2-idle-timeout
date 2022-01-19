# reactor-netty HTTP/1.1 & HTTP/2 idle-timeout

Project that reproduces an issue when using reactor-netty server configured to served on both HTTP/1.1 and HTTP/2 on clear-text,
when set an idle-timeout fails due to be unable to add the `IdleTimeoutHandler` before `reactor.left.httpCodec` because it does not exist.
