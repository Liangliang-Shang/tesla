package com.lshang.tesla;

import quickfix.Application;
import quickfix.SessionID;
import quickfix.Message;
import quickfix.fix44.NewOrderSingle;

public class FIXAcceptorApp implements Application {
    @Override
    public void onLogon(SessionID sessionID) {
    }

    @Override
    public void onLogout(SessionID sessionID) {
    }

    @Override
    public void onCreate(SessionID sessionID) {
    }

    @Override
    public void fromAdmin(Message msg, SessionID sessionID) {
    }

    @Override
    public void toAdmin(Message msg, SessionID sessionID) {
    }

    @Override
    public void fromApp(Message msg, SessionID sessionID) {
    }

    @Override
    public void toApp(Message msg, SessionID sessionID) {
    }

    public void onMessage(NewOrderSingle order, SessionID sessionID) {
    }
}
