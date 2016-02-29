package com.lshang.tesla;

import quickfix.Application;
import quickfix.SessionID;
import quickfix.Message;

public class FIXInitiatorApp implements Application {
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

}
