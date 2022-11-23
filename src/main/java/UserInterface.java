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
                Dolphin program
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
        System.out.print("day: ");
        int day = readInteger();

        System.out.print("month: ");
        int month = readInteger();

        System.out.print("year: ");
        int year = readInteger();

        System.out.print("Phone number: ");
        int phoneNumber = readInteger();

        System.out.print("Address: ");
        String address = readString();

        addNewMember(name, day, month, year, phoneNumber, address);
    }

    public void addNewMember(String name, int day, int month, int year, int phoneNumber, String address){
        System.out.println("""
                Type 1. to add new member as 'exerciser'.
                Type 2. to add new member as 'competition swimmer'.
                Type 0. to discontinue and go to main menu.""");

        int userChoice = readInteger();

        if(userChoice == 1){
            controller.addExerciser(name, day, month, year, phoneNumber, address);
            System.out.println("Exerciser member added.");

        } else if (userChoice == 2){
            //TODO: Fill out with discipline attributes add (future sprint)
            //System.out.println("Add discipline information:");
            controller.addCompetitionSwimmer(name, day, month, year, phoneNumber, address);
            System.out.println("Competition member added.");

        } else if(userChoice == 0){
            System.out.println("Member not added");
        }
    }


    public void viewMember() {
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
        sc.next();
        return sc.nextLine().toLowerCase();
    }
}
