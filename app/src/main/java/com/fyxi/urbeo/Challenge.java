package com.fyxi.urbeo;

/**
 * Created by FrancoisXavier on 2014-09-13.
 */
public class Challenge {
    private String headline;
    private String reporterName;
    private String date;
    private String source;

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
