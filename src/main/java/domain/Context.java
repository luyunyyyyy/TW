package domain;

import java.util.LinkedHashSet;

public class Context {
    private int siteBeginTime = 9;
    private int siteEndTime = 22;
    private LinkedHashSet<String> siteSet;
//    public ArrayList<Item> arrayList;

    public Context() {
        siteSet = new LinkedHashSet<>();
        siteSet.add("A");
        siteSet.add("B");
        siteSet.add("C");
        siteSet.add("D");
    }

    public LinkedHashSet<String> getSiteSet() {
        return siteSet;
    }

    public void setSiteSet(LinkedHashSet<String> siteSet) {
        this.siteSet = siteSet;
    }

    public int getSiteBeginTime() {
        return siteBeginTime;
    }

    public void setSiteBeginTime(int siteBeginTime) {
        this.siteBeginTime = siteBeginTime;
    }

    public int getSiteEndTime() {
        return siteEndTime;
    }

    public void setSiteEndTime(int siteEndTime) {
        this.siteEndTime = siteEndTime;
    }
}
