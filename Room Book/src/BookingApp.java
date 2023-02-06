import java.util.ArrayList;
import java.util.*;
/**
A BookingApp class
*/
public class BookingApp {
    public static void main( String[] args ) {
        //Create uni system and Resources
        BookingSystem system;
        system = new BookingSystem(1);
        UniversityResources resources;
        resources = new UniversityResources(1);
        ArrayList<String> codes = new ArrayList<String>();
        resources.setRoom(new Room("1234", 2));
        codes.add("1234");
        resources.setRoom(new Room("5678", 3));
        codes.add("5678");
        resources.setRoom(new Room("2468", 7));
        codes.add("2468");
        ArrayList<String> assistantEmails = new ArrayList<String>();
        resources.setAssistant(new Assistant("ab12@uok.ac.uk", "Alice Smith"));
        assistantEmails.add("ab12@uok.ac.uk");
        resources.setAssistant(new Assistant("cd34@uok.ac.uk", "John Dean"));
        assistantEmails.add("cd34@uok.ac.uk");
        resources.setAssistant(new Assistant("ef56@uok.ac.uk", "Andy Murray"));
        assistantEmails.add("ef56@uok.ac.uk");
        String input = "";
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(0), "06/07/2021", "07:00", "FULL", 2));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(0), "06/07/2021", "08:00", "AVAILABLE", 1));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(0), "06/07/2021", "09:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(1), "06/07/2021", "07:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(1), "06/07/2021", "08:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(1), "06/07/2021", "09:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(2), "06/07/2021", "07:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(2), "06/07/2021", "08:00", "EMPTY", 0));
        system.setBookableRoom(new BookableRoom(resources.getRooms().get(2), "06/07/2021", "09:00", "EMPTY", 0));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(0), "06/07/2021", "07:00", "BUSY"));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(0), "06/07/2021", "08:00", "BUSY"));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(0), "06/07/2021", "09:00", "FREE"));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(1), "06/07/2021", "07:00", "BUSY"));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(1), "06/07/2021", "08:00", "FREE"));
        system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(1), "06/07/2021", "09:00", "FREE"));
        system.setBooking(new Booking(system.listBookableRooms().get(0), system.listAssistantsOnShift().get(0), "gh01@uok@ac.co.uk", "COMPLETED"));
        system.setBooking(new Booking(system.listBookableRooms().get(0), system.listAssistantsOnShift().get(3), "ij01@uok@ac.co.uk", "SCHEDULED"));
        system.setBooking(new Booking(system.listBookableRooms().get(1), system.listAssistantsOnShift().get(2), "kl01@uok@ac.co.uk", "SCHEDULED"));
        
            
            
            
        String menu = "University of Knowledge - COVID test" + "\n" + "\n" + "Manage Bookings" + "\n" + "\n" + "Please, enter the number to select your option:" + "\n" + "\n" + "To manage Bookable Rooms:" + "\n" + "\t" + "1. List" + "\n" + "\t" + "2. Add" + "\n" + "\t" + "3. Remove" + "\n" + "To manage Assistants on Shift:" + "\n" + "\t" + "4. List" + "\n" + "\t" + "5. Add" + "\n" + "\t" + "6. Remove" + "\n" + "To manage Bookings:" + "\n" + "\t" + "7. List" + "\n" + "\t" + "8. Add" + "\n" + "\t" + "9. Remove" + "\n" + "\t" + "10. Conclude" + "\n" + "After selecting one the options above, you will be presented other screens." + "\n" + "If you press 0, you will be able to return to this main menu." + "\n" + "Press -1 (or ctrl+c) to quit this application." + "\n";
        String page = menu;
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println(menu);
        boolean home = true;
        do {
            //Getting the next user input
            Scanner sc= new Scanner(System.in);  
            String str = sc.nextLine();
            input = str;
            
            //List bookable rooms
            if (input.equals("1")) {
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "List of bookable rooms" + "\n"; 
                for (int i = 0; i < system.listBookableRooms().size(); i++) {
                    page = page + String.valueOf(i+11) +". " + system.listBookableRooms().get(i).getBookableRoom() + "\n";
                }  
                page = page + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                home = false;
            }
            
            //Add bookable rooms
            if (input.equals("2")) {
                
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "Adding bookable room" + "\n" + "\n" + "List of rooms" + "\n";
                for (int i = 0; i < resources.getRooms().size(); i++) {
                    page = page + String.valueOf(i+11) +". " + resources.getRooms().get(i).getRoom() + "\n";
                }
                page = page + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean found = false;
                    boolean exists = false;
                    boolean format = true;
                    boolean bound = true;
                    System.out.println(page);
                    //Getting the next user input for bookable room
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    String[] parts = str1.split(" ");
                    Room room = resources.getRooms().get(0);
                    if (parts.length == 3 && (parts[1].length() - parts[1].replaceAll("/","").length()) == 2 && (parts[2].length() - parts[2].replaceAll(":","").length()) == 1 && parts[1].length() == 10 && parts[2].length() == 5){
                        if (parts[2].equals("07:00") || parts[2].equals("08:00") || parts[2].equals("09:00")){
                            if (resources.getRooms().size() > (Integer.parseInt(parts[0]) - 11)) {
                                    room = resources.getRooms().get(Integer.valueOf(parts[0]) - 11);
                                    found = true;
                                if (found){
                                    for (int i = 0; i < system.listBookableRooms().size(); i++) {
                                        if (system.listBookableRooms().get(i).getRoom() == room && system.listBookableRooms().get(i).getDate().equals(parts[1]) && system.listBookableRooms().get(i).getTime().equals(parts[2])) {
                                            exists = true;
                                        }
                                    }
                                }
                            }
                        } else {
                            bound = false;
                        }
                    } else {
                        format = false;
                    }
                
                    if (!found) {
                        page = "Error" + "\n" + "Room not found" + "\n"+ "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                
                    if (exists) {
                        page = "Error" + "\n" + "Bookable room alreay exists" + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if (!format) {
                        page = "Error" + "\n" + "Incorrect format entered" + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if (!bound) {
                        page = "Error" + "\n" + "Incorrect time slot entered or sequential ID out of bound" + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if (found && !exists && format && bound) {
                        system.setBookableRoom(new BookableRoom(room, parts[1], parts[2], "EMPTY", 0));
                        page = "Bookable Room added successfully:" + "\n" + system.listBookableRooms().get(system.listBookableRooms().size() - 1).getBookableRoom() + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    home = false;
                    if (!home && str1.equals("0")) {
                        page = menu;
                        home = true;
                    }
                input = str1;
                }
            }
            
            // Remove bookable room
            if (input.equals("3")) {
                ArrayList<Integer> deletes = new ArrayList<Integer>();
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "List of bookable rooms Status: EMPTY" + "\n";
                int count = 0;
                for (int i = 0; i < system.listBookableRooms().size(); i++) {
                    if (system.listBookableRooms().get(i).getStatus().equals("EMPTY")) {
                        page = page + String.valueOf(count+11) +". " + system.listBookableRooms().get(i).getBookableRoom() + "\n";
                        count = count + 1;
                    }
                }
                page = page + "Removing bookable room" + "\n" + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the bookable room to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean found = false;
                    System.out.println(page);
                    String transcript = "";
                    //Getting the next user input for bookable room
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    int counter = 11;
                    if (system.listBookableRooms().size() > (Integer.parseInt(str1) - 11)) {
                        for (int i = 0; i < system.listBookableRooms().size(); i++) {
                            if (system.listBookableRooms().get(i).getStatus().equals("EMPTY")){
                                if(counter == Integer.parseInt(str1)) {
                                    transcript = system.listBookableRooms().get(i).getBookableRoom();
                                    deletes.add(i);
                                    found = true;
                                }
                                counter = counter + 1;
                            }
                            
                        }
                        
                    }
                    if (found) {
                        page = "Bookable Room removed successfully:" + "\n" + transcript + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the bookable room to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    if (!found) {
                        page = "Error!" + "\n" + "Index out of range" + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the bookable room to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    home = false;
                    if (!home && str1.equals("0")) {
                        for(int i = deletes.size() - 1; i >= 0; i--) {
                            system.listBookableRooms().remove(deletes.get(i).intValue());
                        }
                        page = menu;
                        home = true;
                    }
                input = str1;
                }
            }
            
            //List Assistants on shift
            if (input.equals("4")) {
                page = "University of Knowledge - COVID test" + "\n" + "\n"; 
                for (int i = 0; i < system.listAssistantsOnShift().size(); i++) {
                    page = page + String.valueOf(i+11) +". " + system.listAssistantsOnShift().get(i).getAssistantOnShift() + "\n";
                }  
                page = page + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                home = false;
            }
            
            //Add assistant on shift
            if (input.equals("5")) {
                
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "Adding assistant on shift" + "\n" + "\n";
                for (int i = 0; i < resources.getAssistants().size(); i++) {
                    page = page + String.valueOf(i+11) +". " + resources.getAssistants().get(i).getAssistant() + "\n";
                }
                page = page + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean bound = false;
                    boolean format = false;
                    System.out.println(page);
                    boolean exists = false;
                    //Getting the next user input for assistant on shift
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    String[] parts = str1.split(" ");
                    if (resources.getAssistants().size() > (Integer.parseInt(parts[0]) - 11) && !str1.equals("-1") && !str1.equals("0")) {
                        bound = true;
                        String[] dates = parts[1].split("/");
                        if (parts.length == 2 && dates.length == 3 && parts[0].length() == 2 && parts[1].length() == 10) {
                            format = true;
                            for (int i = 0; i < system.listAssistantsOnShift().size(); i++) {
                                if (system.listAssistantsOnShift().get(i).getEmail().equals( resources.getAssistants().get(Integer.parseInt(parts[0])-11).getEmail()) && system.listAssistantsOnShift().get(i).getDate().equals(parts[1])){
                                    exists = true;
                                }
                            }
                            if(!exists){
                                for(int i = 0; i < 3; i++) {
                                    system.setAssistantOnShift(new AssistantOnShift(resources.getAssistants().get(Integer.parseInt(parts[0])-11), parts[1], "0" + String.valueOf(i+7) + ":00", "FREE"));
                                }
                            }
                        }
                    }
                    if (!bound) {
                        page = "Error!" + "\n" + "Sequential ID out of bounds" + "\n" +  "Please enter one of the following:" + "\n" + "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if (!format) {
                         page = "Error!" + "\n" + "Incorrect format entered" + "\n" +  "Please enter one of the following:" + "\n" + "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if(exists) {
                        page = "Error!" + "\n" + "This assistant is already on shift on inputted date" + "\n" +  "Please enter one of the following:" + "\n" + "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    
                    if (bound && format && !exists){
                        page = "Assistant on Shift added successfully:" + "\n";
                        page = page + system.listAssistantsOnShift().get(system.listAssistantsOnShift().size() - 1).getAssistantOnShift();
                        page = page + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                }
                input = str1;
                home = false;
                if (!home && str1.equals("0")) {
                        page = menu;
                        home = true;
                }
            }
            
            //Removing assistants on shift
            if (input.equals("6")) {
                ArrayList<Integer> deletes1 = new ArrayList<Integer>();
                int count = 0;
                page = "University of Knowledge - COVID test" + "\n" + "\n" ;
                for (int i = 0; i < system.listAssistantsOnShift().size(); i++) {
                    if(system.listAssistantsOnShift().get(i).getStatus().equals("FREE")){
                        page = page + String.valueOf(count+11) +". " + system.listAssistantsOnShift().get(i).getAssistantOnShift() + "\n";
                        count = count + 1;
                    }
                }
                page = page + "Removing assistant on shift" + "/n" + "/n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the assistant on shift to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean found = false;
                    System.out.println(page);
                    String transcript = "";
                    //Getting the next user input for bookable room
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    int counter = 11;
                    if (system.listAssistantsOnShift().size() > (Integer.parseInt(str1) - 11)) {
                        for (int i = 0; i < system.listAssistantsOnShift().size(); i++) {
                            if (system.listAssistantsOnShift().get(i).getStatus().equals("FREE")){
                                if(counter == Integer.parseInt(str1)) {
                                    transcript = system.listAssistantsOnShift().get(i).getAssistantOnShift();
                                    deletes1.add(i);
                                    found = true;
                                }
                                counter = counter + 1;
                            }
                            
                            
                        }
                        
                    }
                    if (found) {
                        page = "Bookable Room removed successfully:" + "\n" + transcript + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the bookable room to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    if (!found) {
                        page = "Error!" + "\n" + "Index out of range" + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID to select the bookable room to be removed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                
                home = false;
                    if (!home && str1.equals("0")) {
                        for(int i = deletes1.size() - 1; i >= 0; i--) {
                            system.listAssistantsOnShift().remove(deletes1.get(i).intValue());
                        }
                        page = menu;
                        home = true;
                    }
                input = str1;
                }
            }
            
            //List managable bookings 
            if (input.equals("7")) {
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "Select which booking to list:" + "\n" + "1. All" + "\n" + "2. Only bookings Status: SCHEDULED" + "\n" + "3. Only bookings Status: COMPLETED" + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application" + "\n";
                String str1 = "";
                System.out.println(page);
                Scanner sc1= new Scanner(System.in);  
                str1 = sc1.nextLine();
                page = "";
                if (str1.equals("2")) {
                    for (int i = 0; i < system.listBookings().size(); i++) {
                        if (system.listBookings().get(i).getStatus().equals("SCHEDULED")) {
                            page = page + (String.valueOf(i + 11)) + ". " + system.listBookings().get(i).getBooking() + "\n";
                        }
                    }
                    page = page + "0. Back to main menu." + "\n" + "-1. Quit application" + "\n";
                } else if (str1.equals("3")) {
                    for (int i = 0; i < system.listBookings().size(); i++) {
                        if (system.listBookings().get(i).getStatus().equals("COMPLETED")) {
                            page = page + (String.valueOf(i + 11)) + ". " + system.listBookings().get(i).getBooking() + "\n";
                        }
                    }
                    page = page + "0. Back to main menu." + "\n" + "-1. Quit application" + "\n";
                } else if (str1.equals("0")) {
                    page = menu;
                }
                else {
                    for (int i = 0; i < system.listBookings().size(); i++) {
                        page = page + (String.valueOf(i + 11)) + ". " + system.listBookings().get(i).getBooking() + "\n";
                    }
                    page = page + "0. Back to main menu." + "\n" + "-1. Quit application" + "\n";
                }
                home = false;
            }
            
            //Add bookings 
            if (input.equals("8")) {
                ArrayList<String> timeSlots = new ArrayList<String>();
                int counter = 11;
                String str1 = "";
                boolean email = true;
                boolean exists = true;
                boolean bounds = false;
                page = "University of Knowledge - COVID test" + "\n" + "\n" + "Adding booking (appointment for a COVID test) to the system" + "\n" + "List of available time-slots:" + "\n";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    for(int i = 0; i < system.listBookableRooms().size(); i++) {
                        for(int q = 0; q < system.listAssistantsOnShift().size(); q++){
                            if (system.listBookableRooms().get(i).getDate().equals(system.listAssistantsOnShift().get(q).getDate()) && system.listBookableRooms().get(i).getTime().equals(system.listAssistantsOnShift().get(q).getTime())) {
                                if (!timeSlots.contains(system.listBookableRooms().get(i).getDate() + " " + system.listBookableRooms().get(i).getTime())) {
                                    timeSlots.add(system.listBookableRooms().get(i).getDate() + " " + system.listBookableRooms().get(i).getTime());
                                    page = page + String.valueOf(counter) + ". " + system.listBookableRooms().get(i).getDate() + " " + system.listBookableRooms().get(i).getTime() + "\n";
                                    counter = counter + 1;
                                }
                            }
                        }
                    }
                    page = page + "\n" + "Please, enter one of the following:" + "\n" + "\n" + "The sequential ID of an available time-slot and the student email, separated by a white space." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    System.out.println(page);
                    //Getting the next user input for assistant on shift
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    String time = "";
                    String[] timeParts = {};
                    if (!str1.equals("0") && !str1.equals("-1")){
                        String parts[] = str1.split(" ");
                        if (Integer.parseInt(parts[0])-11 < 0 || Integer.parseInt(parts[0])-11 > timeSlots.size()-1){
                            bounds = true;
                        }else if (!parts[1].endsWith("@uok.ac.uk")){
                            email = false;
                        } else {
                            time = timeSlots.get(Integer.parseInt(parts[0]) - 11);
                            timeParts = time.split(" ");
                            for(int i = 0; i < system.listBookableRooms().size(); i++) {
                                for(int q = 0; q < system.listAssistantsOnShift().size(); q++) {
                                    if (system.listBookableRooms().get(i).getDate().equals(system.listAssistantsOnShift().get(q).getDate()) && system.listBookableRooms().get(i).getTime().equals(system.listAssistantsOnShift().get(q).getTime())) {
                                        if(system.listBookableRooms().get(i).getDate().equals(timeParts[0]) && system.listBookableRooms().get(i).getTime().equals(timeParts[1]) && exists) {
                                            system.setBooking(new Booking(system.listBookableRooms().get(i), system.listAssistantsOnShift().get(q), parts[1], "SCHEDULED"));
                                            system.listBookableRooms().get(i).addOccupancy();
                                            if(system.listBookableRooms().get(i).getRoom().getCapacity() ==     system.listBookableRooms().get(i).getOccupancy()) {
                                                system.listBookableRooms().get(i).setStatus("FULL");
                                            }
                                            system.listAssistantsOnShift().get(q).setStatus("BUSY");
                                            exists = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!exists && !bounds && email) {
                        page = "Booking added successfully:" + "\n" + system.listBookings().get(system.listBookings().size() - 1).getBooking() + "\n" + "\n";
                    }
                    if (!email) {
                        page = "Error" + "\n" + "Email is in incorrect format" + "\n" + "\n";
                    }
                    if (bounds) {
                        page = "Error" + "\n" + "Sequential ID out of range" + "\n" + "\n";
                    }
                }
                input = str1;
                home = false;
                if (!home && str1.equals("0")) {
                    page = menu;
                    home = true;
                }
            }
            
            //Remove bookings 
            if (input.equals("9")) {
                ArrayList<Integer> deletes2 = new ArrayList<Integer>();
                page = "University of Knowledge - COVID test" + "\n";
                int check = 11;
                for(int i = 0; i < system.listBookings().size(); i++) {
                    if(system.listBookings().get(i).getStatus().equals("SCHEDULED")) {
                        page = page + String.valueOf(check) + ". " + system.listBookings().get(i).getBooking() + "\n";
                        check = check + 1;
                    }
                }
                page = page + "Removing booking from the system" + "\n" +"\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be removed from the listed bookings above." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean found = false;
                    System.out.println(page);
                    String transcript = "";
                    //Getting the next user input for bookable room
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    int counter = 11;
                    if (system.listBookings().size() > (Integer.parseInt(str1) - 11)) {
                        for (int i = 0; i < system.listBookings().size(); i++) {
                            if (system.listBookings().get(i).getStatus().equals("SCHEDULED")){
                                if(counter == Integer.parseInt(str1)) {
                                    transcript = system.listBookings().get(i).getBooking();
                                    deletes2.add(i);
                                    found = true;
                                }
                                counter = counter + 1;
                            }
                        }
                    }
                    if (found) {
                        page = "Booking removed successfully:" + "\n" + transcript + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be removed from the listed bookings above." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    if (!found) {
                        page = "Error!" + "\n" + "Index out of range" + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be removed from the listed bookings above." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                
                    home = false;
                    if (!home && str1.equals("0")) {
                        for(int i = deletes2.size() - 1; i >= 0; i--) {
                            system.listBookings().remove(deletes2.get(i).intValue());
                        }
                        page = menu;
                        home = true;
                    }
                input = str1;
                }
            }
            
            //List managable bookings 
            if (input.equals("10")) {
                page = "University of Knowledge - COVID test" + "\n" + "\n";
                int check = 11;
                for(int i = 0; i < system.listBookings().size(); i++) {
                    if(system.listBookings().get(i).getStatus().equals("SCHEDULED")) {
                        page = page + String.valueOf(check) + ". " + system.listBookings().get(i).getBooking() + "\n";
                        check = check + 1;
                    }
                }
                page = page + "Conclude booking" + "\n" +"\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be completed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                 String str1 = "";
                while (!str1.equals("0") && !str1.equals("-1")) {
                    boolean found = false;
                    System.out.println(page);
                    String transcript = "";
                    //Getting the next user input for bookable room
                    Scanner sc1= new Scanner(System.in);  
                    str1 = sc1.nextLine();
                    int counter = 11;
                    if (system.listBookings().size() > (Integer.parseInt(str1) - 11)) {
                        for (int i = 0; i < system.listBookings().size(); i++) {
                            if (system.listBookings().get(i).getStatus().equals("SCHEDULED")){
                                if(counter == Integer.parseInt(str1)) {
                                    system.listBookings().get(i).setStatus("COMPLETED");
                                    transcript = system.listBookings().get(i).getBooking();
                                    found = true;
                                }
                                counter = counter + 1;
                            }
                        }
                    }
                    if (found) {
                        page = "Booking completed successfully:" + "\n" + transcript + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be completed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                    if (!found) {
                        page = "Error!" + "\n" + "Index out of range" + "\n" + "Please enter one of the following:" + "\n" + "\n" + "The sequential ID to select the booking to be completed." + "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
                    }
                
                    home = false;
                    if (!home && str1.equals("0")) {
                        page = menu;
                        home = true;
                    }
                input = str1;
                }
            }
            
            
            //Return to menu
            if (!home && input.equals("0")) {
                page = menu;
                home = true;
            }
            //print page
            if (!input.equals("-1")) {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println(page);
            }
        } while (!input.equals("-1")); 
    }
}