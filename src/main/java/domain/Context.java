package domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Context {
    private int siteBeginTime = 9;
    private int siteEndTime = 22;
    private LinkedHashSet<String> siteSet;

    public ArrayList<BookingItem> bookingItems;

    public Context() {
        siteSet = new LinkedHashSet<>();
        siteSet.add("A");
        siteSet.add("B");
        siteSet.add("C");
        siteSet.add("D");
        bookingItems = new ArrayList<>();
    }

    public ArrayList<BookingItem> getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(ArrayList<BookingItem> bookingItems) {
        this.bookingItems = bookingItems;
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
