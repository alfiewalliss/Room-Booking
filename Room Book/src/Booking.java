/**
A Booking class
*/
public class Booking {
    private BookableRoom bookableRoom;
    private AssistantOnShift assistantOnShift;
    private String email;
    private String status;
    
    //Method: set the status of a booking
    public void setStatus(String status) {
        this.status = status;
    }
    
    // Method: Returns the data in the print template of Booking
    public String getBooking() {
        return ("| " + this.assistantOnShift.getDate() + " " + this.assistantOnShift.getTime() + " | " + this.status + " | " + this.assistantOnShift.getEmail() + " | " + bookableRoom.getCode() + " | " + this.email + " |");
    }
    
    //Method: Returns teh status of the Booking
    public String getStatus() {
        return this.status;
    }
    
    //Constructor to create Booking object
    public Booking(BookableRoom bookableRoom, AssistantOnShift assistantOnShift, String email, String status) {
        this.bookableRoom = bookableRoom;
        this.assistantOnShift = assistantOnShift;
        this.email = email;
        this.status = status;
    }
}