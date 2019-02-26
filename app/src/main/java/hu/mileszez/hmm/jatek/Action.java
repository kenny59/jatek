package hu.mileszez.hmm.jatek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Action {
    int id;
    static Calendar startDate = Calendar.getInstance();
    static Calendar endDate = Calendar.getInstance();
    static String name;
    double timeNeeded;
    double progress;
    static String desc;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    public Action(int endD, String nam, String des, double timeN, String... ab) {
        parseDate(endD, endDate);
        name = nam;
        timeNeeded = timeN;
        des = desc;
    }

    private boolean parseDate(int timeStampIn, Calendar out) {
        try {
            out.setTime(simpleDateFormat.parse(String.valueOf(timeStampIn)));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String getDateInHumanFormat(Calendar in) {
        return simpleDateFormat.format(in.getTime());
    }

    public static String printInfo() {
        return (getDateInHumanFormat(startDate)+ " " +getDateInHumanFormat(endDate)+ " " +name);
    }
}
