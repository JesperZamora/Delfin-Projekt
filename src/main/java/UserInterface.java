import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private Controller controller;

    public UserInterface(){
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    public void startMenu(){
        System.out.println("""
                Welcome to the interface of the dolphin swimming club!
                Make your choice:
                
                1. Member management (President menu)
                2. Cash management (Cashier menu)
                3. Teams and statistics (Coach menu)
                9. Quit
                """);
    }

    public void startMenuCommand(){
        boolean isRunning = true;
        while(isRunning) {
            startMenu();
            int userChoice = readInteger();
            switch(userChoice) {
                case 1 -> presidentMenu();
                case 2 -> cashierMenu();
                case 3 -> coachMenu();
                case 9 -> isRunning = false;
                default -> System.out.println("Not valid menu choice");
            }
        }
    }

    public void presidentMenu(){
        System.out.println("""
                1. Add member
                2. Edit member
                3. Show members
                """);
        int userChoice = readInteger();
        switch(userChoice) {
            case 1 -> addNewMemberInfo();
            case 2 -> editMember();
            case 3 -> viewMember();
            default -> System.out.println("Wrong input");
        }
    }

    public void cashierMenu(){
        System.out.println("""
                1. Show subscriptions
                2. Sum of subscriptions
                3. Show arrears
                """);
        int userChoice = readInteger();
        switch (userChoice){
            case 1 -> System.out.println(" *** KONTINGENT (TO BE ADDED HERE) ***");
            case 2 -> System.out.println(" *** SUMMEN AF KONTINGENT (TO BE ADDED HERE) ***");
            case 3 -> System.out.println(" *** RESTANCE (TO BE ADDED HERE) ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void coachMenu(){
        System.out.println("""
                1. Show division of competitive swimmers
                2. Register competitive swimmers to specific disciplines
                3. Show top 5 swimmers in each discipline
                """);
        int userChoice = readInteger();
        switch (userChoice){
            case 1 -> System.out.println(" *** DIVISION OF COMPETITIVE SWIMMERS TO BE ADDED HERE ***");
            case 2 -> System.out.println(" *** COMPETITIVE SWIMMERS REGISTERED TO SPECIFIC DISCIPLINES TO BE ADDED HERE ***");
            case 4 -> System.out.println(" *** TOP 5 IN EACH DISCIPLINE TO BE ADDED HERE ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void addNewMemberInfo(){
        System.out.println("Add new member information");
        System.out.print("Name: ");
        String name = readString();

        System.out.println("Birthdate ");
        System.out.print("Day: ");
        int day = readInteger();

        System.out.print("Month: ");
        int month = readInteger();

        System.out.print("Year: ");
        int year = readInteger();

        System.out.print("Phone no: ");
        int phoneNumber = readInteger();

        System.out.print("Address: ");
        String address = readString();

        addNewMember(name, day, month, year, phoneNumber, address);
    }

    public void addNewMember(String name, int day, int month, int year, int phoneNumber, String address){
        System.out.println("""
                \nType 1. to add new member as 'exerciser'.
                Type 2. to add new member as 'competition swimmer'.
                Type 0. to discontinue and go to main menu.""");

        int userChoice = readInteger();

        if(userChoice == 1){
            controller.addExerciser(name, day, month, year, phoneNumber, address);
            System.out.println("\nExerciser member added.");

        } else if (userChoice == 2){
            //TODO: Fill out with discipline attributes add (future sprint)
            //System.out.println("Add discipline information:");
            controller.addCompetitionSwimmer(name, day, month, year, phoneNumber, address);
            System.out.println("\nCompetition member added.");

        } else if(userChoice == 0){
            System.out.println("\nMember not added");
        }
    }

    public void editMember(){
        System.out.println("Write the name of the member you wish to edit: ");
        String searchName = readString();
        ArrayList<Member> searchedMember = controller.searchMemberName(searchName);
        System.out.println(searchedMember.toString());

        System.out.println("Write the number of the member you wish to edit (1st is number 1...) ");
        int memberChoice = readInteger();
        System.out.println("Now editing.");

        System.out.println("Edit name: ");
        String newName = readString();

        System.out.println("Edit day of birth: ");
        int newDay = readInteger();

        System.out.println("Edit month of birth: ");
        int newMonth = readInteger();

        System.out.println("Edit year of birth: ");
        int newYear = readInteger();

        System.out.println("Edit phone number: ");
        int newPhoneNumber = readInteger();

        System.out.println("Edit address: ");
        String newAddress = readString();

        controller.editMember(newName, newDay, newMonth, newYear, newPhoneNumber, newAddress, memberChoice);
    }

    public void viewMember() {
        System.out.println("Name:              Age:    Birthdate:    Phone no.    Address:                    Membership:");
        controller.getMembers().forEach(System.out :: println);
    }

    public int readInteger(){
        while(!sc.hasNextInt()){
            System.out.println("This is not a number. Try again..");
            sc.next();
        }
        return sc.nextInt();
    }

    public String readString(){
        sc.nextLine();
        return sc.nextLine().toLowerCase();
    }



}



