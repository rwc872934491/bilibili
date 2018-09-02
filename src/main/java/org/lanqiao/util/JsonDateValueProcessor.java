package org.lanqiao.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonDateValueProcessor implements JsonValueProcessor {

    private String format = "YYYY-MM-dd hh:mm:ss";
    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value){

        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}
