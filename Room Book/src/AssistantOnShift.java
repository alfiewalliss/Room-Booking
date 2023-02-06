/**
A Assistant On Shift class
*/
public class AssistantOnShift {
    private String time;
    private String date;
    private String status;
    private Assistant assistant;
    
    //Method: Set the status of a AssistantOnShift
    public void setStatus(String status) {
        this.status = status;
    }
    
    // Method: Returns the data in the print template of AssistantOnShift
    public String getAssistantOnShift() {
        return ("| " + this.date + " " + this.time + " | " + status + " | " + this.assistant.getEmail() + " |");
    }
    
    // Method: Returns the time of AssistantOnShift
    public String getTime() {
        return this.time;
    }
    
    //Method: Returns the date of AssistantOnShift
    public String getDate() {
        return this.date;
    }
    
    //Method: Returns the email of AssistantOnShift
    public String getEmail() {
        return this.assistant.getEmail();
    }
    
    //Method: Returns the status of AssistantOnShift
    public String getStatus() {
        return this.status;
    }
    
    //Constructor to make AssistantOnShift object
    public AssistantOnShift (Assistant assistant, String date, String time, String status) {
        this.time = time;
        this.date = date;
        this.status = status;
        this.assistant = assistant;
    }
    
}