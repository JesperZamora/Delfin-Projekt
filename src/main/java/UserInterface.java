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
                case 1 -> addExerciser();
                case 2 -> viewMember();
                case 9 -> isRunning = false;
                default -> System.out.println("Not valid menu choice");
            }
        }
    }


    public void addMemberMenu(){
        System.out.println("""
                Membership:
                1. Exerciser
                2. Competition Swimmer""");
    }
    public void addExerciser(){
        System.out.println("Add new member information");
        System.out.print("Name: ");
        sc.next();
        String name = sc.nextLine();

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
        String address = sc.nextLine();
        System.out.println("Press * to add member");

        if(!sc.hasNext()){
            controller.addExerciser(name, day, month, year, phoneNumber, address);
            System.out.println("Exerciser member added.");
        } else {
            //System.out.println("Add discipline information:");
            controller.addCompetitionSwimmer(name, day, month, year, phoneNumber, address);
            System.out.println("Competition member added.");
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
}
