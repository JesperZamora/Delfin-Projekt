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
                
                1. President menu
                2. Cashier menu
                3. Coach menu
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
            case 1 -> System.out.println(" *** ADD MEMBER TO BE ADDED HERE ***");
            case 2 -> System.out.println(" *** EDIT MEMBER TO BE ADDED HERE ***");
            case 3 -> System.out.println(" *** SHOW MEMBERS TO BE ADDED HERE ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void cashierMenu(){
        System.out.println("""
                1. Show subscriptions
                2. Show arrears
                3. Sum of arrears
                """);
        int userChoice = readInteger();
        switch (userChoice){
            case 1 -> System.out.println(" *** SHOW SUBSCRIPTION TO BE ADDED HERE ***");
            case 2 -> System.out.println(" *** ARREARS TO BE ADDED HERE ***");
            case 3 -> System.out.println(" *** SUM OF ARREARS TO BE ADDED HERE ***");
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
