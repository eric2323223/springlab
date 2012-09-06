1.bin/active-admin: uncomment JMX options.
                    set max memory from 512M to 2048M, and set min memory and new generation memory size. 
2.conf/activemq.xml: set <system usage>, 1)memory from 64m to 512m, 2)disk from 100g to 10g, 3)temp from 10g to 1g
                     set <destinationPolicy> memory limit from 1m to 20m
                     predefine destinations
3.conf/activemq-network-broker.xml:set networkConnector and transportConnector multicast from default to special group name.
                                   set networkConnector conduitSubscriptions=false
                                   set transportConnector updateClusterClients/updateClusterClientsOnRemove/rebalanceClusterClients=true

4.conf/jetty.xml: remove demo,camel and fileserver application.
