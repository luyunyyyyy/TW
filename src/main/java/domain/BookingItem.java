package domain;

import java.util.Objects;

import static util.Util.isWeekend;

public class BookingItem implements Comparable<BookingItem> {
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

    @Override
    public int compareTo(BookingItem o) {
        //this.bookingDate.compareTo(o.getBookingDate());


        return this.getBookingDate().compareTo(o.getBookingDate());
    }

    public double getMoneyOfBooking() {
        double money = 0;

        if (!isWeekend(this.getBookingDate())) {
            for (int time = this.getBeginHour(); time < this.endHour; time++) {
                switch (time) {
                    case 9:
                    case 10:
                    case 11:
                        money += 30;
                        break;
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        money += 50;
                        break;
                    case 18:
                    case 19:
                        money += 80;
                        break;
                    case 20:
                    case 21:
                        money += 60;
                        break;
                }
            }
        } else {
            for (int time = this.getBeginHour(); time < this.endHour; time++) {
                switch (time) {
                    case 9:
                    case 10:
                    case 11:
                        money += 40;
                        break;
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        money += 50;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        money += 60;
                        break;
                }
            }
        }
        return money;
    }
    //private
}
