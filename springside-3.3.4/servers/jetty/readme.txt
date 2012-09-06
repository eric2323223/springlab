1.jetty.xml:
  a.remove useless setting.
  b.set connector from SelectChannelConnector to BlockingChannelConnector for graceful shutdown
  c.set gracefulshutdown from 1 second to 5 seconds.
2.jetty-jmx.xml: no customize yet.