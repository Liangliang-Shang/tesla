package com.lshang.tesla;

import quickfix.ConfigError;
import quickfix.SessionSettings;
import quickfix.Application;
import quickfix.FileStoreFactory;
import quickfix.FileLogFactory;
import quickfix.DefaultMessageFactory;
import quickfix.SocketAcceptor;

public class FIXAcceptor {
    public static void main(String[] args) throws ConfigError {
        SessionSettings settings = new SessionSettings("conf/acceptor.conf");
        Application app = new FIXAcceptorApp();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        FileLogFactory log = new FileLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketAcceptor acceptor = new SocketAcceptor(app, fileStoreFactory, 
            settings, log, msgFactory);
        acceptor.start();
    }
}
