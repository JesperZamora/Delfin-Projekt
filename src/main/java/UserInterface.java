import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private Controller controller;

    public UserInterface() {
        sc = new Scanner(System.in);
        controller = new Controller();
        controller.loadFile();
    }

    public void startMenu() {
        System.out.println("""
                Welcome to the interface of the dolphin swimming club!
                Make your choice:
                                
                1. Member management (President menu)
                2. Cash management (Cashier menu)
                3. Teams and statistics (Coach menu)
                9. Quit
                """);
    }

    public void startMenuCommand() {
        boolean isRunning = true;
        while (isRunning) {
            startMenu();
            int userChoice = readInteger();
            switch (userChoice) {
                case 1 -> presidentMenu();
                case 2 -> cashierMenu();
                case 3 -> coachMenu();
                case 9 -> {
                    controller.saveFile();
                    isRunning = false;
                }
                default -> System.out.println("Not valid menu choice");
            }
        }
    }

    public void presidentMenu() {
        System.out.println("""
                1. Add member
                2. Edit member
                3. Show members
                """);
        int userChoice = readInteger();
        switch (userChoice) {
            case 1 -> addNewMemberInfo();
            case 2 -> editMember();
            case 3 -> viewMember();
            default -> System.out.println("Wrong input");
        }
    }

    public void cashierMenu() {
        System.out.println("""
                1. Show subscriptions
                2. Sum of subscriptions
                3. Show arrears
                """);
        int userChoice = readInteger();
        switch (userChoice) {
            case 1 -> System.out.println(" *** KONTINGENT (TO BE ADDED HERE) ***");
            case 2 -> System.out.println(" *** SUMMEN AF KONTINGENT (TO BE ADDED HERE) ***");
            case 3 -> System.out.println(" *** RESTANCE (TO BE ADDED HERE) ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void coachMenu() {
        System.out.println("""
                1. Show division of competitive swimmers
                2. Register competitive swimmers to specific disciplines
                3. Show top 5 swimmers in each discipline
                """);
        int userChoice = readInteger();
        switch (userChoice) {
            case 1 -> System.out.println(" *** DIVISION OF COMPETITIVE SWIMMERS TO BE ADDED HERE ***");
            case 2 ->
                    System.out.println(" *** COMPETITIVE SWIMMERS REGISTERED TO SPECIFIC DISCIPLINES TO BE ADDED HERE ***");
            case 4 -> System.out.println(" *** TOP 5 IN EACH DISCIPLINE TO BE ADDED HERE ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void addNewMemberInfo() {
        System.out.println("Add new member information");
        System.out.print("Name: ");
        String name = readString();

        System.out.println("Birthdate ");
        System.out.print("Type your birthdate in this format: dd-mm-yyyy ");
        //formatter
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // string date
        String birthDate = readString();
        //localdate parse
        LocalDate birthDateParsed = LocalDate.parse(birthDate, format);

        System.out.print("Phone no: ");
        int phoneNumber = readInteger();

        System.out.print("Address: ");
        String address = readString();

        System.out.println("Membership Status");
        boolean memberStatus = Boolean.parseBoolean(readString());

        addNewMember(name, birthDateParsed, phoneNumber, address, memberStatus);
    }

    public void addNewMember(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus) {
        System.out.println("""
                \nType 1. to add new member as 'exerciser'.
                Type 2. to add new member as 'competition swimmer'.
                Type 0. to discontinue and go to main menu.""");

        int userChoice = readInteger();

        if (userChoice == 1) {
            controller.addExerciser(name, birthDate, phoneNumber, address, memberStatus);
            System.out.println("\nExerciser member added.");

        } else if (userChoice == 2) {
            //TODO: Fill out with discipline attributes add (future sprint)
            //System.out.println("Add discipline information:");
            controller.addCompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus);
            System.out.println("\nCompetition member added.");

        } else if (userChoice == 0) {
            System.out.println("\nMember not added");
        }
    }


    public void editMember() {
        System.out.println("Write the name of the member you wish to edit: ");
        String searchName = readString();
        ArrayList<Member> searchedMember = controller.searchMemberName(searchName);

        int no = 1;
        for (Member member : searchedMember) {
            System.out.println("[" + no + "] " + member);
            no++;
        }

        int choice = readInteger();

        Member foundMembers = searchedMember.get(choice - 1);

        System.out.println("Write the number of the member you wish to edit (1st is number 1...) ");
        int memberChoice = readInteger();
        System.out.println("Now editing.");

        System.out.println("Edit name: ");
        String newName = readString();
        if (!newName.isEmpty()) {
            foundMembers.setName(newName);
        }

        System.out.println("Edit date of birth in this format: dd-mm-yyyy ");
        String newBirthDate = readString();
        LocalDate birthDatePassed = null;
        if (!newBirthDate.isEmpty()) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            birthDatePassed = LocalDate.parse(newBirthDate, format);
            foundMembers.setBirthDate(birthDatePassed);
        }

        System.out.println("Edit phone number: ");
        String newPhoneNumber = readString();
        newPhoneNumber = Integer.toString(Integer.parseInt(newPhoneNumber));
        if (!newPhoneNumber.isEmpty()) {
            foundMembers.setPhoneNumber(Integer.parseInt(newPhoneNumber));
        }

        System.out.println("Edit address: ");
        String newAddress = readString();
        if (!newAddress.isEmpty()) {
            foundMembers.setAddress(newAddress);
        }

        //controller.editMember(newName, birthDatePassed, Integer.parseInt(newPhoneNumber), newAddress, memberChoice);
        controller.ageCalculator();
    }

    public void viewMember() {
        System.out.println("Name:              Age:    Birthdate:    Phone no.    Address:                    Membership:");
        controller.getMembers().forEach(System.out::println);
    }

    public int readInteger() {
        while (!sc.hasNextInt()) {
            System.out.println("This is not a number. Try again..");
            sc.next();
        }
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    public String readString() {
        return sc.nextLine().toLowerCase();
    }


}



