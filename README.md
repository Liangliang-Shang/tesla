# tesla
A simple FIX Initiator/Acceptor Demo

## Demo
1. start FIXAcceptor
```Shell
20160302 19:58:34 lshang@elemos:/home/lshang/devel/tesla 
$ source bin/startTesla.bash 
20160302 19:59:00 lshang@elemos:/home/lshang/devel/tesla 
$ make acceptor 
cd /home/lshang/devel/tesla/src && find . -name "*.java" -exec javac -d /home/lshang/devel/tesla/tmp {} \;
cd  /home/lshang/devel/tesla/tmp && jar cvf tesla.jar com && mv tesla.jar /home/lshang/devel/tesla/lib
added manifest
adding: com/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/FIXAcceptorApp.class(in = 770) (out= 360)(deflated 53%)
adding: com/lshang/tesla/order/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/order/TeslaOrderList.class(in = 2867) (out= 1553)(deflated 45%)
adding: com/lshang/tesla/order/TeslaOrder.class(in = 1195) (out= 658)(deflated 44%)
adding: com/lshang/tesla/FIXAcceptor.class(in = 893) (out= 516)(deflated 42%)
adding: com/lshang/tesla/FIXInitiator.class(in = 2988) (out= 1608)(deflated 46%)
adding: com/lshang/tesla/FIXInitiatorApp.class(in = 664) (out= 325)(deflated 51%)
java com/lshang/tesla/FIXAcceptor
Mar 02, 2016 7:59:18 PM quickfix.SessionSchedule <init>
INFO: [FIX.4.4:FIXAcceptor->FIXInitiator] daily, 00:00:00-UTC - 00:00:00-UTC
Mar 02, 2016 7:59:19 PM quickfix.mina.SessionConnector startSessionTimer
INFO: SessionTimer started
Mar 02, 2016 7:59:19 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketReuseAddress=true
Mar 02, 2016 7:59:19 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketTcpNoDelay=true
Mar 02, 2016 7:59:19 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWrites=false
Mar 02, 2016 7:59:19 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWriteTimeout=30000
Mar 02, 2016 7:59:19 PM quickfix.mina.acceptor.AbstractSocketAcceptor startAcceptingConnections
INFO: Listening for connections at 0.0.0.0/0.0.0.0:20160 for session(s) [FIX.4.4:FIXAcceptor->FIXInitiator]
```
2. start FIXInitiator
```Shell
20160302 20:01:40 lshang@elemos:/home/lshang/devel/tesla 
$ source bin/startTesla.bash 
20160302 20:01:44 lshang@elemos:/home/lshang/devel/tesla 
$ make initiator 
cd /home/lshang/devel/tesla/src && find . -name "*.java" -exec javac -d /home/lshang/devel/tesla/tmp {} \;
cd  /home/lshang/devel/tesla/tmp && jar cvf tesla.jar com && mv tesla.jar /home/lshang/devel/tesla/lib
added manifest
adding: com/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/FIXAcceptorApp.class(in = 770) (out= 360)(deflated 53%)
adding: com/lshang/tesla/order/(in = 0) (out= 0)(stored 0%)
adding: com/lshang/tesla/order/TeslaOrderList.class(in = 2867) (out= 1553)(deflated 45%)
adding: com/lshang/tesla/order/TeslaOrder.class(in = 1195) (out= 658)(deflated 44%)
adding: com/lshang/tesla/FIXAcceptor.class(in = 893) (out= 516)(deflated 42%)
adding: com/lshang/tesla/FIXInitiator.class(in = 2988) (out= 1608)(deflated 46%)
adding: com/lshang/tesla/FIXInitiatorApp.class(in = 664) (out= 325)(deflated 51%)
java com/lshang/tesla/FIXInitiator
Mar 02, 2016 8:01:53 PM quickfix.SessionSchedule <init>
INFO: [FIX.4.4:FIXInitiator->FIXAcceptor] daily, 00:00:00-UTC - 00:00:00-UTC
Mar 02, 2016 8:01:54 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketTcpNoDelay=true
Mar 02, 2016 8:01:54 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWrites=false
Mar 02, 2016 8:01:54 PM quickfix.mina.NetworkingOptions logOption
INFO: Socket option: SocketSynchronousWriteTimeout=30000
Mar 02, 2016 8:01:54 PM quickfix.mina.initiator.IoSessionInitiator <init>
INFO: [FIX.4.4:FIXInitiator->FIXAcceptor] [/127.0.0.1:20160]
Mar 02, 2016 8:01:54 PM quickfix.mina.SessionConnector startSessionTimer
INFO: SessionTimer started
Mar 02, 2016 8:01:54 PM quickfix.mina.initiator.InitiatorIoHandler sessionCreated
INFO: MINA session created for FIX.4.4:FIXInitiator->FIXAcceptor: local=/127.0.0.1:38793, class org.apache.mina.transport.socket.nio.SocketSessionImpl, remote=/127.0.0.1:20160
```
## MessageLog
```Text
8=FIX.4.49=17035=D34=143=Y49=FIXInitiator52=20160302-12:01:55.09856=FIXAcceptor122=20160302-12:01:5411=TeslaOrder038=100040=244=45.0454=155=60027660=20160302-12:01:54.26110=020
8=FIX.4.49=10435=434=243=Y49=FIXInitiator52=20160302-12:01:55.09956=FIXAcceptor122=20160302-12:01:5536=3123=Y10=235
8=FIX.4.49=14435=D34=349=FIXInitiator52=20160302-12:01:59.27856=FIXAcceptor11=TeslaOrder138=1200040=244=15.0454=155=00197960=20160302-12:01:54.26110=035
8=FIX.4.49=14535=D34=449=FIXInitiator52=20160302-12:02:04.28556=FIXAcceptor11=TeslaOrder238=13400040=244=14.0454=155=00197960=20160302-12:01:54.26110=079
8=FIX.4.49=14435=D34=549=FIXInitiator52=20160302-12:02:09.28956=FIXAcceptor11=TeslaOrder338=1900040=244=45.9454=155=60027660=20160302-12:01:54.26110=051
```

## TelsaOrder
TeslaOrder extends NewOrderSingle and default ClOrdID/TransactTime, or maybe more fields like Currency/TimeInForce. 

## TelsaOrderList
TeslaOrderList reads a csv file and parse the lines containing fields to composite an order like Side/Symbol/Price/OrderQty/OrdType

## FIXInitiator/FIXAcceptor
Mostly copied from Banzai.
