package com.fyxi.urbeo;

/**
 * Created by FrancoisXavier on 2014-09-13.
 */
public class Challenge {
    public final static int WHAT = 0;
    public final static int WHERE = 1;
    public final static int HOW = 2;
    public final static int BONUS = 3;
    public final static int IMG = 4;

    private String headline;
    private String location;
    private String description;
    private String bonusDescr;
    private String source;

    public Challenge(String[] attributes) {
        setHeadline(attributes[WHAT]);
        setLocation(attributes[WHERE]);
        setDescription(attributes[HOW]);
        setBonusDescr(attributes[BONUS]);
        setImageSource(attributes[IMG]);
    }

    public Challenge(String what, String where, String description, String bonus, String source) {
        setHeadline(what);
        setLocation(where);
        setDescription(description);
        setBonusDescr(bonus);
        setImageSource(source);
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String reporterName) {
        this.location = reporterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSource() {
        return this.source;
    }

    public void setImageSource(String source) {
        this.source = source;
    }

    public void setBonusDescr(String bonusDescr) { this.bonusDescr = bonusDescr; }

    public String getBonusDescr() { return bonusDescr; }

    /*
     * TODO add to toString()
     */
    @Override
    public String toString() {
        return "[ headline=" + headline + ", location=" +
                location + " , description=" + description + "]";
    }
}
