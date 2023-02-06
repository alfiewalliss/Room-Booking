import java.util.ArrayList;
/**
A UniversityReasources class
*/
public class UniversityResources {
    private ArrayList<Assistant> assistants = new ArrayList<Assistant>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int temp;
    
    //Method: Add assistants to the UniversityReasources assistants list
    public void setAssistant(Assistant assistant) {
        this.assistants.add(assistant);
    }
    
    //Method: Add rooms to the UniversityReasources rooms list
    public void setRoom(Room room) {
        this.rooms.add(room);
    }
    
    //Method: Return the list of assistants
    public ArrayList<Assistant> getAssistants() {
        return this.assistants;
    }
    
    //Method: Return the list of rooms
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }
    
    //Constructor to make UniversityReasource object
    public UniversityResources(int temp) {
        this.temp = temp;
    }
}