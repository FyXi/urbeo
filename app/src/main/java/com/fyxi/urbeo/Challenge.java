package com.fyxi.urbeo;

/**
 * Created by FrancoisXavier on 2014-09-13.
 */
public class Challenge {
    public final static int WHAT = 0;
    public final static int WHERE = 1;
    public final static int HOW = 2;
    public final static int BONUS = 3;

    private String headline;
    private String reporterName;
    private String date;
    private String source;
    
    public Challenge(String[] attributes) {
        setHeadline(attributes[WHAT]);
        setReporterName(attributes[WHERE]);
        setDate(attributes[HOW]);
        setImageSource(attributes[BONUS]);
    }

    public Challenge(String what, String where, String how, String bonus) {
        setHeadline(what);
        setReporterName(where);
        setDate(how);
        setImageSource(bonus);
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageSource() {
        return this.source;
    }

    public void setImageSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "[ headline=" + headline + ", reporter Name=" +
                reporterName + " , date=" + date + "]";
    }
}
