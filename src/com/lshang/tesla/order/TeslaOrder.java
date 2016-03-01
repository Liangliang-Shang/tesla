package com.lshang.tesla.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.field.ClOrdID;
import java.util.Date;
import quickfix.field.TransactTime;
import quickfix.fix44.NewOrderSingle;

public class TeslaOrder {
    private static final Logger log = 
            LoggerFactory.getLogger(TeslaOrder.class);
    private static int count = 0;
    private static NewOrderSingle order = null;

    public TeslaOrder() {
        order = new NewOrderSingle();
        order.set(new ClOrdID("TeslaOrder" + count));
        order.set(new TransactTime(new Date()));
        count++;
    }
    
    public NewOrderSingle getNewOrderSingle() {
        return this.order;
    }
}
