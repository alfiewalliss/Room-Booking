/**
A assistant class
*/
public class Assistant {
    private String email;
    private String name;
    
    // Method: Returns the data in the print template of assistant
    public String getAssistant() {
        return ("| " + this.name + " | " + this.email + " |");
    }
    
    // Method: Returns the assistants email
    public String getEmail() {
        return this.email;
    }
    
    // Constructor to make assistant object
    public Assistant(String email, String name) {
        if (name != "" && email.endsWith("@uok.ac.uk")) {
            this.email = email;
            this.name = name;
        }
    }
}