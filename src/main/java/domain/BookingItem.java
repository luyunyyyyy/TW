package domain;

import java.util.Date;

public class BookingItem {
    private String userId;
    private Date bookingDate;
    private int beginHour;
    private int endHour;
    private String siteId;

    public BookingItem(String userId, Date bookingDate, int beginHour, int endHour, String siteId) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.siteId = siteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(int beginHour) {
        this.beginHour = beginHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    //private
}