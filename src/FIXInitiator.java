package com.lshang.tesla;
import com.lshang.tesla.order.TeslaOrderList;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = 
            LoggerFactory.getLogger(FIXInitiator.class);
    private static SocketInitiator initiator; 
    private boolean initiatorStarted = false;

    public FIXInitiator(String[] args) throws ConfigError {
        SessionSettings settings = new SessionSettings("conf/initiator.conf");

        boolean logHeartbeats =
            Boolean.valueOf(System.getProperty("logHeartbeats", "true"));

        Application app = new FIXInitiatorApp();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        FileLogFactory log = new FileLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        initiator= new SocketInitiator(app, fileStoreFactory, 
            settings, log, msgFactory);
    }

    public synchronized void logon() {
        if(!initiatorStarted) {
            try {
                initiator.start();
                initiatorStarted = true;
            } catch(Exception e) {
                log.error("Start failed", e);
            }
        } else {
            for(SessionID sessionId : initiator.getSessions()) {
                Session.lookupSession(sessionId).logon();
            }
        }
    }

    public void logout() {
        for(SessionID sessionId : initiator.getSessions()) {
            Session.lookupSession(sessionId).logout("User requested!");
        }
    }

    public static void main(String[] args) throws Exception {
        FIXInitiator fixInitiator = new FIXInitiator(args);
        if(!System.getProperties().containsKey("FIXInitiator")) {
            fixInitiator.logon();
        }

        SessionID sessionID = new SessionID("FIX.4.4", 
            "FIXInitiator", "FIXAcceptor");
        
        ArrayList<NewOrderSingle> orderList 
            = (new TeslaOrderList("tmp/TeslaOrders.csv")).getOrderList();
        for(NewOrderSingle order : orderList) {
            Session.sendToTarget(order, sessionID);
            Thread.sleep(5000);
        }
/*
        NewOrderSingle order = new NewOrderSingle();
        order.set(new ClOrdID("Tesla"));
        order.set(new Side(Side.BUY));
        order.set(new TransactTime(new Date()));
        order.set(new OrdType(OrdType.LIMIT));
        order.set(new OrderQty(100));
        order.set(new Price(25.40));
        order.set(new Symbol("BHP"));
*/
        

    }
}
