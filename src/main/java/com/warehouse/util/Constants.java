package com.warehouse.util;

import java.util.Map;
import java.util.TreeMap;

public class Constants {

    //-- SEN stands for Script Engine Name
    public static final String SEN_NASHORN = "nashorn";


    public static final String PT_MONTHLY = "M";
    public static final String PT_QUARTERLY = "Q";
    public static final String PT_YEARLY = "Y";


    public static final Map<String, String> PERIODS_MAP;
    public static final Map<String, String> ELEGER_PERIODS_MAP;
    public static final Map<Integer, String> INVOICE_TYPE;

    static {
        PERIODS_MAP = new TreeMap<>();
        PERIODS_MAP.put("01", "January");
        PERIODS_MAP.put("02", "February");
        PERIODS_MAP.put("03", "March");
        PERIODS_MAP.put("04", "April");
        PERIODS_MAP.put("05", "May");
        PERIODS_MAP.put("06", "June");
        PERIODS_MAP.put("07", "July");
        PERIODS_MAP.put("08", "August");
        PERIODS_MAP.put("09", "September");
        PERIODS_MAP.put("10", "October");
        PERIODS_MAP.put("11", "November");
        PERIODS_MAP.put("12", "December");
        PERIODS_MAP.put("21", "I Quarter");
        PERIODS_MAP.put("22", "II Quarter");
        PERIODS_MAP.put("23", "III Quarter");
        PERIODS_MAP.put("24", "IV Quarter");
        PERIODS_MAP.put("00", "Year");

        ELEGER_PERIODS_MAP = new TreeMap<>();
        ELEGER_PERIODS_MAP.put("M01", "January");
        ELEGER_PERIODS_MAP.put("M02", "February");
        ELEGER_PERIODS_MAP.put("M03", "March");
        ELEGER_PERIODS_MAP.put("M04", "April");
        ELEGER_PERIODS_MAP.put("M05", "May");
        ELEGER_PERIODS_MAP.put("M06", "June");
        ELEGER_PERIODS_MAP.put("M07", "July");
        ELEGER_PERIODS_MAP.put("M08", "August");
        ELEGER_PERIODS_MAP.put("M09", "September");
        ELEGER_PERIODS_MAP.put("M10", "October");
        ELEGER_PERIODS_MAP.put("M11", "November");
        ELEGER_PERIODS_MAP.put("M12", "December");
        ELEGER_PERIODS_MAP.put("Q01", "I Quarter");
        ELEGER_PERIODS_MAP.put("Q02", "II Quarter");
        ELEGER_PERIODS_MAP.put("Q03", "III Quarter");
        ELEGER_PERIODS_MAP.put("Q04", "IV Quarter");
        ELEGER_PERIODS_MAP.put("Y00", "Year");

        INVOICE_TYPE = new TreeMap<>();
        INVOICE_TYPE.put(0, "Standard");
        INVOICE_TYPE.put(1, "Export");
        INVOICE_TYPE.put(2, "Import");
    }
}
