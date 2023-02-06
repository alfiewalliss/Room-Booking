import java.util.ArrayList;
/**
A Booking System class
*/
public class BookingSystem {
    private ArrayList<BookableRoom> bookableRooms = new ArrayList<BookableRoom>();
    private ArrayList<AssistantOnShift> assistantsOnShift = new ArrayList<AssistantOnShift>(); 
    private ArrayList<Booking> bookings = new ArrayList<Booking>(); 
    private int temp;
    
    //Method: Add Bookable Rooms to bookableRooms list
    public void setBookableRoom(BookableRoom bookableRoom) {
        this.bookableRooms.add(bookableRoom);
    }
    
    //Method: Remove Bookable Rooms from bookableRooms list
    public void removeBookableRoom(BookableRoom bookableRoom) {
        this.bookableRooms.remove(bookableRoom);
    }
    
    //Method: List Bookable Rooms from bookableRooms list
    public ArrayList<BookableRoom> listBookableRooms() {
        return this.bookableRooms;
    }
    
    //Method: Add Assistant On Shift to assistantsOnShift list
    public void setAssistantOnShift(AssistantOnShift assistantOnShift) {
        this.assistantsOnShift.add(assistantOnShift);
    }
    
    //Method: Remove Assistant On Shift from assistantsOnShift list
    public void removeAssistantOnShift(AssistantOnShift assistantOnShift) {
        this.assistantsOnShift.remove(assistantOnShift);
    }
    
    //Method: List Assistants On Shift from assistantsOnShift list
    public ArrayList<AssistantOnShift> listAssistantsOnShift() {
        return this.assistantsOnShift;
    }
    
    //Method: Add Booking to bookings list
    public void setBooking(Booking booking) {
        this.bookings.add(booking);
    }
    
    //Method: Remove Booking from bookings list
    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }
    
    //Method: List Assistants On Shift from assistantsOnShift list
    public ArrayList<Booking> listBookings() {
        return this.bookings;
    }
    
    //Constructor to make Booking system object
    public BookingSystem(int temp) {
        this.temp = temp;
    }
}