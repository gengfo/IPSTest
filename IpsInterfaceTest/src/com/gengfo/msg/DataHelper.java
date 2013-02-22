package com.gengfo.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {

    public static String getTemplate(String tempRes) {
        StringBuffer sb = new StringBuffer();
        InputStream stream = ClassLoader.getSystemResourceAsStream(tempRes);
        BufferedReader brInvAdjEntries = new BufferedReader(new InputStreamReader(stream));
        String sqlLine;
        try {
            sqlLine = brInvAdjEntries.readLine();
            while (sqlLine != null) {
                sb.append(sqlLine);
                sqlLine = brInvAdjEntries.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    public static String getJoNumber(String prefix, int currentCount) {
        DateFormat df = new SimpleDateFormat("yyyyMMDDHHmmss");
        return prefix + (df.format(new Date()) + currentCount);
    }

}
