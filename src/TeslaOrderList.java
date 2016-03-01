package com.lshang.tesla.order;

import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import quickfix.DataDictionary;
import quickfix.ConfigError;
import quickfix.StringField;
import quickfix.fix44.NewOrderSingle;

public class TeslaOrderList {
    private static final Logger log
            = LoggerFactory.getLogger(TeslaOrderList.class);
    private static DataDictionary dataDict; 
    private static ArrayList<NewOrderSingle> orderList
            = new ArrayList<NewOrderSingle>();

    public TeslaOrderList(String orderFile) throws ConfigError {
        dataDict = new DataDictionary("conf/FIX.4.4.xml");
        File file = new File(orderFile);
        BufferedReader reader = null;
        NewOrderSingle order = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                order = (new TeslaOrder()).getNewOrderSingle();
                String[] pairs = line.split(",");
                for(String pair : pairs) {
                    int tag = -1;
                    String val = "";
                    if(pair != null && pair.indexOf("=") > 0) {
                        String[] fields = pair.split("=");
                        tag = dataDict.getFieldTag(fields[0]);
                        if(fields[1].indexOf('-') > 0) {
                            val = fields[1].split("-")[0];
                        }
                        else {
                            val = fields[1];
                        }
                    } 
                    if( tag != -1 && val != "") {
                        StringField stringField = new StringField(tag, val);
                        order.setField(stringField);
                    }
                }
                orderList.add(order);
            }
            reader.close();
        } catch(IOException e) {
            log.error("Failed to read orders from " + orderFile, e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("Failed to close reader of " + orderFile, e);
                }
            }
        }
    }

    public ArrayList<NewOrderSingle> getOrderList() {
        return this.orderList;
    }
}
