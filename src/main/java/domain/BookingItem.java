package domain;

import java.util.Objects;

public class BookingItem {
    private String userId;
    private String bookingDate;
    private int beginHour;
    private int endHour;
    private String siteId;

    private boolean breakBooking;

    public boolean isBreakBooking() {
        return breakBooking;
    }

    public void setBreakBooking(boolean breakBooking) {
        this.breakBooking = breakBooking;
    }

    public BookingItem(String userId, String bookingDate, int beginHour, int endHour, String siteId) {
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

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingItem that = (BookingItem) o;
        return beginHour == that.beginHour &&
                endHour == that.endHour &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(bookingDate, that.bookingDate) &&
                Objects.equals(siteId, that.siteId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, bookingDate, beginHour, endHour, siteId);
    }
    //private
}
