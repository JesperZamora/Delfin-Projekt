import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                \nWelcome to the interface of the dolphin swimming club!
                
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
            case 2 -> searchMember();
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
            case 1 -> viewCompMembersOver18();
            case 2 -> addDiscipline();
            case 3 -> System.out.println(" *** TOP 5 IN EACH DISCIPLINE TO BE ADDED HERE ***");
            default -> System.out.println("Wrong input");
        }
    }

    public void addNewMemberInfo() {
        System.out.println("Add new member information");
        System.out.print("Name: ");
        String name = readString();

        System.out.print("Birth date (date-month-year): ");
        LocalDate birthDate = addDate();

        System.out.print("Phone no: ");
        int phoneNumber = readInteger();

        System.out.print("Address: ");
        String address = readString();

        System.out.println("""
                Set membership status
                1. Active
                2. Passive
                3. Inactive""");
        System.out.print("Membership Status: ");
        int memberStatusChoice = readInteger();
        String memberStatus = "";
        while(memberStatus.isBlank()){
            switch (memberStatusChoice){
                case 1 -> memberStatus = "Active";
                case 2 -> memberStatus = "Passive";
                case 3 -> memberStatus = "Inactive";
                default -> System.out.println("Invalid input.. Choose again!");
            }
        }

        addNewMember(name, birthDate, phoneNumber, address, memberStatus);
    }

    public void addNewMember(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        System.out.println("""
                \nType 1. to add new member as 'exerciser'.
                Type 2. to add new member as 'competition swimmer'.
                Type 0. to discontinue and go to main menu.""");

        int userChoice = readInteger();

        if (userChoice == 1) {
            controller.addExerciser(name, birthDate, phoneNumber, address, memberStatus);
            System.out.println("\nExerciser member added.");

        } else if (userChoice == 2) {
            controller.addCompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus);
            System.out.println("\nCompetition member added.");


        } else if (userChoice == 0) {
            System.out.println("\nMember not added");
        }
    }

    public void addDiscipline(){
        System.out.println("Search for competition swimmer:");
        String searchWord = readString();

        ArrayList<CompetitionSwimmer> foundComSwimmer = new ArrayList<>();
        int num = 1;
        for(Member member : controller.searchMember(searchWord)) {
            if(member instanceof CompetitionSwimmer) {
                foundComSwimmer.add((CompetitionSwimmer) member);
                System.out.println("Member #[" + num + "] \n" + member);
                num++;
            }
        }


        System.out.print("Choose:");
        int choice = readInteger();
        CompetitionSwimmer competitionSwimmer = foundComSwimmer.get(choice-1);

        boolean isRunning = true;
        do{
            System.out.println("Choose a number to add a discipline");
            System.out.println("""
                    1. Breaststroke
                    2. Butterfly
                    3. Crawl
                    4. Backstroke""");

            String disciplineName = "";
            switch (readInteger()){
                case 1 -> disciplineName = "Breaststroke";
                case 2 -> disciplineName = "Butterfly";
                case 3 -> disciplineName = "Crawl";
                case 4 -> disciplineName = "Backstroke";
                default -> System.out.println("Invalid number");
            }

            System.out.print("Best time: ");
            double bestTime = readDouble();

            System.out.print("Date of best time: ");
            LocalDate date = addDate();

            competitionSwimmer.addNewDiscipline(disciplineName, bestTime, date);

            System.out.println("Add another discipline press 1 or exit press 0");
            int userChoice = readInteger();
            if(userChoice != 1){
                isRunning = false;
            }
        }while(isRunning);
    }

    public void searchMember(){
        System.out.print("Search member by name, age or phone number: ");
        String searchWord = readString();
        ArrayList<Member> searchedMember = controller.searchMember(searchWord);
        if(searchedMember.isEmpty()) {
            System.out.println("No member found..");
            System.out.println("Search again? Try again press 1 or exit press 2");
            int choice = readInteger();
            if(choice == 1) {
                searchMember();
            }
        } else {
            int no = 1;
            for (Member member : searchedMember) {
                System.out.println("Member #[" + no + "] \n" + member);
                no++;
            }
            editMember(searchedMember);
        }
    }


    public void editMember(ArrayList<Member> searchedMember) {
        System.out.println("\nChoose members number to edit or press 0 to exit");
        int choice = readInteger();
        if(choice != 0) {
            Member foundMembers = searchedMember.get(choice - 1);
            System.out.print("Name: ");
            String newName = readString();
            if (!newName.isEmpty()) {
                foundMembers.setName(newName);
            }

            System.out.print("Birth date (date-month-year): ");
            LocalDate newBirthDate = editBirthDate(readString());
            if(newBirthDate != null) {
                foundMembers.setBirthDate(newBirthDate);
            }

            //TODO: not robust code needs methode for exceptions
            System.out.print("Phone no: ");
            String newPhoneNumber = readString();
            if (!newPhoneNumber.isEmpty()) {
                foundMembers.setPhoneNumber(Integer.parseInt(newPhoneNumber));
            }

            System.out.print("Address: ");
            String newAddress = readString();
            if (!newAddress.isEmpty()) {
                foundMembers.setAddress(newAddress);
            }

            System.out.println("""
                Edit membership status
                1. active
                2. passive
                3. inactive""");
            System.out.print("Set member status: ");
            String newMemberStatusChoice = readString();
            if(!newMemberStatusChoice.isEmpty()) {
                String newMemberStatus = "";
                switch (Integer.parseInt(newMemberStatusChoice)){
                    case 1 -> newMemberStatus = "active";
                    case 2 -> newMemberStatus= "passive";
                    case 3 -> newMemberStatus = "inactive";
                    default -> System.out.println("Invalid input.. Choose again!");
                }
                foundMembers.setMemberStatus(newMemberStatus);
            }

        }
    }

    public LocalDate addDate(){
        LocalDate birthDateParsed = null;
        while(birthDateParsed == null){
            String birthDate = readString();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                birthDateParsed = LocalDate.parse(birthDate, format);
            } catch(DateTimeParseException parseException) {
                System.out.println("Invalid format. Try again..");
            }
        }
        return birthDateParsed;
    }
    public LocalDate editBirthDate(String check){
        LocalDate birthDateParsed = null;
        String birthDate = check;
        while(!birthDate.isEmpty()){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                birthDateParsed = LocalDate.parse(birthDate, format);
            } catch(DateTimeParseException parseException) {
                System.out.println("Invalid format. Try again..");
            }
            if(birthDateParsed != null){
                break;
            } else {
                birthDate = readString();
            }
        }
        return birthDateParsed;
    }

    public void viewMember() {
        controller.getMembers().forEach(System.out::println);
    }
    public void viewCompMembersOver18() {
        controller.sortCompGroupByAge();
        System.out.println(controller.getCompMembersUnder18() + "Group 2 over 18:" + controller.getCompMembersOver18());
    }

    public void showTopFive(){
        ArrayList<CompetitionSwimmer> competitionSwimmers = new ArrayList<>();
        controller.sortCompGroupByAge();
        for (Member members : controller.getMembers()){
            if (members instanceof CompetitionSwimmer){
                competitionSwimmers.add((CompetitionSwimmer) members);
            }
        }

        for (int i = 0; i<5; i++){

        }
    }

    public void juniorCompetitionSwimmers(){
        System.out.println("Junior Competition swimmers:");
        for(Member members: controller.getMembers()){
            if(members instanceof CompetitionSwimmer && members.getAge() <18){
                System.out.println(members + "\n");
            }
        }
    }

    public void seniorCompetitionSwimmers(){
        System.out.println("Senior Competition swimmers:");
        for(Member members: controller.getMembers()){
            if(members instanceof CompetitionSwimmer && members.getAge() >=18){
                System.out.println(members + "\n");
            }
        }
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
        return sc.nextLine();
    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {
            System.out.println("This is not a number. Try again..");
            sc.next();
        }
        double i = sc.nextDouble();
        sc.nextLine();
        return i;
    }

}



