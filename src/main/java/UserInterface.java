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
                \nDolphin program
                1. add member
                2. view members / member
                9. quit program""");
    }

    public void startMenuCommand(){
        boolean isRunning = true;
        while(isRunning) {
            startMenu();
            int userChoice = readInteger();
            switch(userChoice) {
                case 1 -> addNewMemberInfo();
                case 2 -> viewMember();
                case 9 -> isRunning = false;
                default -> System.out.println("Not valid menu choice");
            }
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
