/**
A room class
*/
public class Room {
    private String code;
    private int capacity;
    
    //Method: Returns the data in the print template of room
    public String getRoom() {
        return ("| " + this.code + " | capacity: " + String.valueOf(capacity) + " |");
    }
    
    //Method: Returns the room code
    public String getCode() {
        return this.code;
    }
    
    //Method: Returns the room capacity
    public int getCapacity() {
        return this.capacity;
    }
    
    //Constructor to make room object
    public Room(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
    }
} 