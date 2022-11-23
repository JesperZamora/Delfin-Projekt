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
                Delfin program
                1. add member
                2. view member
                9. quit program""");
    }

    public void startMenuCommand(){
        boolean isRunning = true;
        while(isRunning) {
            startMenu();
            int userChoice = readInteger();
            switch(userChoice) {
                case 1 -> addMember();
                case 2 -> viewMember();
                case 9 -> isRunning = false;
                default -> System.out.println("Not valid menu choice");
            }
        }
    }

    public void addMember(){
        System.out.println("not working yet");
    }
    public void viewMember() {
        System.out.println("not working yet");
    }

    public int readInteger(){
        while(!sc.hasNextInt()){
            System.out.println("This is not a number. Try again..");
            sc.next();
        }
        return sc.nextInt();
    }
}
