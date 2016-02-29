package com.lshang.tesla;

import quickfix.ConfigError;
import quickfix.SessionSettings;
import quickfix.Application;
import quickfix.FileStoreFactory;
import quickfix.FileLogFactory;
import quickfix.DefaultMessageFactory;
import quickfix.SocketInitiator;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.SessionID;
import quickfix.field.ClOrdID;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.Price;
import quickfix.field.Side;
import quickfix.field.Symbol;
import java.util.Date;
import quickfix.field.TransactTime;
import quickfix.fix44.NewOrderSingle;

public class FIXInitiator {
    public static void main(String[] args) 
        throws ConfigError, SessionNotFound, InterruptedException {
        SessionSettings settings = new SessionSettings("conf/initiator.conf");
        Application app = new FIXInitiatorApp();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        FileLogFactory log = new FileLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketInitiator initiator= new SocketInitiator(app, fileStoreFactory, 
            settings, log, msgFactory);
        initiator.start();
        Thread.sleep(3000);

        SessionID sessionID = new SessionID("FIX.4.4", 
            "FIXInitiator", "FIXAcceptor");

        NewOrderSingle order = new NewOrderSingle();
        order.set(new ClOrdID("Tesla"));
        order.set(new Side(Side.BUY));
        order.set(new TransactTime(new Date()));
        order.set(new OrdType(OrdType.LIMIT));
        order.set(new OrderQty(100));
        order.set(new Price(25.40));
        order.set(new Symbol("BHP"));
        Session.sendToTarget(order, sessionID);
        
        Thread.sleep(5000);

    }
}
