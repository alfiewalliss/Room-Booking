/**
A BookableRoomClass
*/
public class BookableRoom {
    private Room room;
    private String date;
    private String time;
    private String status;
    private int occupancy;
    
    //Method: Set the occupancy of a BookableRoom
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
    
    //Method: Set the status of a BookableRoom
    public void setStatus(String status) {
        this.status = status;
    }
    
    //Method: Add one to the value of occupancy
    public void addOccupancy() {
        this.occupancy = this.occupancy + 1;
    }
    //Method: Returns the value of date
    public String getDate() {
        return this.date;
    }
    
    //Method: Returns the value of time
    public String getTime() {
        return this.time;
    }
    
    //Method: Returns the value of room
    public Room getRoom() {
        return this.room;
    }
    
    //Method: Returns the value of status
    public String getStatus() {
        return this.status;
    }
    
    //Method Returns the value of occupancy
    public int getOccupancy () {
        return this.occupancy;
    }
    // Method: Returns the data in the print template of BookableRoom
    public String getBookableRoom() {
        return ("| " + this.date + " " + this.time + " | " + this.status + " | " + this.room.getCode() + " | occupancy: " + String.valueOf(occupancy) + " |");
    }
    
    //Method: Returns the code of the room
    public String getCode() {
        return this.room.getCode();
    }
    
    //Constructor to make BookableRoom object
    public BookableRoom(Room room, String date, String time, String status, int occupancy) {
        this.room = room;
        this.date = date;
        this.time = time;
        this.status = status;
        this.occupancy = occupancy;
    }
}