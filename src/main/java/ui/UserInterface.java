package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import domain.*;

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
            case 2 -> editMember();
            case 3 -> viewMember();
            default -> System.out.println("Wrong input");
        }
    }

    public void cashierMenu() {
        System.out.println("""
                1. Show members
                2. Edit payment of members
                3. Sum of subscriptions
                4. Show unpaid members
                """);
        int userChoice = readInteger();
        switch (userChoice) {
            case 1 -> viewMembersWithPrice();
            case 2 -> registerIfPaid(); //System.out.println(" *** KONTINGENT (TO BE ADDED HERE) ***");
            case 3 -> System.out.println("Sum of subscriptions: "+ controller.getSumOfSubscriptions(controller.getMembers()));
            case 4 -> membersWithOutstanding();
            default -> System.out.println("Wrong input");
        }
    }


    public void registerIfPaid(){
        ArrayList<Member> foundMembers = searchMember();
        System.out.println("\nChoose members number to edit or press 0 to exit");
        int choice = readInteger();

        if(choice != 0) {
            try {
                Member member = foundMembers.get(choice - 1);
                System.out.println("""
                Register member as paid or not paid
                1. Paid
                2. Not paid""");
                int paymentChoice = readInteger();
                switch (paymentChoice){
                    case 1 -> {member.setIsPaid(true);
                        System.out.println("Payment successfully set to PAID");}
                    case 2 -> {member.setIsPaid(false);
                        System.out.println("Payment succesfully set to NOT PAID");}
                    default -> System.out.println("Not valid choice..");
                }

            }catch (IndexOutOfBoundsException e) {
                System.out.println("No member by that number..");
                registerIfPaid();
            }
        }
    }


    public void membersWithOutstanding(){
        System.out.println("Members with outstanding balance:");
        for(Member member : controller.getMembers()){
            if(!member.isPaid() && !member.MemberStatus().equalsIgnoreCase("inactive")){
                System.out.println(member);
            }
        }
    }


    public void coachMenu() {
        System.out.println("""
                1. Show division of competitive swimmers
                2. Add discipline data to competitive swimmer
                3  Edit discipline date of competitive swimmer
                4. Show all swimmers
                5. Show top 5 swimmers in each discipline
                """);
        int userChoice = readInteger();
        switch (userChoice) {
            case 1 -> {sortCompJuniorSwimmers(); sortCompSeniorSwimmer();}
            case 2 -> addDiscipline();
            case 3 -> editDiscipline();
            case 4 -> showAllSwimmers();
            case 5 -> System.out.println(" *** TOP 5 IN EACH DISCIPLINE TO BE ADDED HERE ***");
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
                \n1. to add new member as 'exerciser'.
                2. to add new member as 'competition swimmer'.
                0. to discontinue and go to main menu.""");

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

    public ArrayList<Member> searchMember(){
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
                System.out.println("#" + no + " " + member);
                no++;
            }
        }
        return searchedMember;
    }


    public void editMember() {
        ArrayList<Member> foundMembers = searchMember();
        System.out.println("\nChoose members number to edit or press 0 to exit");
        int choice = readInteger();
        if(choice != 0) {
            Member member = foundMembers.get(choice - 1);
            System.out.print("Name: ");
            String newName = readString();
            if (!newName.isEmpty()) {
                member.setName(newName);
            }

            System.out.print("Birth date (date-month-year): ");
            LocalDate newBirthDate = editDate(readString());
            if(newBirthDate != null) {
                member.setBirthDate(newBirthDate);
            }

            //TODO: not robust code needs methode for exceptions
            System.out.print("Phone no: ");
            String newPhoneNumber = readString();
            if (!newPhoneNumber.isEmpty()) {
                member.setPhoneNumber(Integer.parseInt(newPhoneNumber));
            }

            System.out.print("Address: ");
            String newAddress = readString();
            if (!newAddress.isEmpty()) {
                member.setAddress(newAddress);
            }

            System.out.println("""
                Edit membership status
                1. Active
                2. Passive
                3. Inactive""");
            System.out.print("Set member status: ");
            String newMemberStatusChoice = readString();
            if(!newMemberStatusChoice.isEmpty()) {
                String newMemberStatus = "";
                switch (Integer.parseInt(newMemberStatusChoice)){
                    case 1 -> newMemberStatus = "Active";
                    case 2 -> newMemberStatus= "Passive";
                    case 3 -> newMemberStatus = "Inactive";
                    default -> System.out.println("Invalid input.. Choose again!");
                }
                member.setMemberStatus(newMemberStatus);
            }

        }
    }


    private void showAllSwimmers(){
        ArrayList<Member> swimmerList = controller.getMembers();
        System.out.println("Swimmer list:");
        if(swimmerList.isEmpty()){
            System.out.println("List is empty..");

        } else{
            for(Member member : swimmerList){
                if(member instanceof CompetitionSwimmer) {
                    System.out.println(member);
                    for(SwimTime discipline : ((CompetitionSwimmer) member).getDisciplines()){
                        if(discipline != null){
                            System.out.println(discipline);
                        }
                    }
                    System.out.println();

                } else {
                    System.out.println(member + "\n");
                }
            }
        }
    }
    private void addDiscipline(){
        ArrayList<CompetitionSwimmer> competitionSwimmers = new ArrayList<>();
        for(Member member : controller.getMembers()) {
            if(member instanceof CompetitionSwimmer) {
                competitionSwimmers.add(((CompetitionSwimmer)member));
            }
        }

        for(CompetitionSwimmer swimmer : competitionSwimmers){
            System.out.println("#" + (competitionSwimmers.indexOf(swimmer)+1) + "\n" + swimmer + "\n");
        }

        System.out.print("Competitor by number: ");
        int userChoice = readInteger();
        CompetitionSwimmer swimmerChosen = competitionSwimmers.get(userChoice-1);

        System.out.print("Location name: ");
        String location = readString();

        System.out.print("Datec(date-month-year): ");
        LocalDate date = addDate();

        System.out.println("""
                Set discipline
                1. Breaststroke
                2. Backstroke
                3. Butterfly
                4. Crawl""");

        System.out.println("Discipline: ");
        int choice = readInteger();

        String discipline= "";
        while(discipline.isBlank()){
            switch (choice){
                case 1 -> discipline = "Breaststroke";
                case 2 -> discipline = "Backstroke";
                case 3 -> discipline = "Butterfly";
                case 4 -> discipline = "Crawl";
                default -> System.out.println("Invalid input.. Choose again!");
            }
        }

        System.out.println("Swimmer time: ");
        double time = readDouble();

        swimmerChosen.addAbility(new SwimTime(location,date,discipline,time));
    }

    private void editDiscipline(){
        ArrayList<CompetitionSwimmer> editSwimmers = new ArrayList<>();
        for(Member member : controller.getMembers()) {
            if(member instanceof CompetitionSwimmer) {
                editSwimmers.add(((CompetitionSwimmer)member));
            }
        }

        for(CompetitionSwimmer swimmer : editSwimmers){
            System.out.println("#" + (editSwimmers.indexOf(swimmer)+1) + "\n" + swimmer + "\n");
        }

        System.out.print("Competitor by number: ");
        int userChoice = readInteger();
        CompetitionSwimmer swimmerChosen = editSwimmers.get(userChoice-1);

        int num = 1;
        for(SwimTime discipline : swimmerChosen.getDisciplines()){
            if(discipline != null){
                System.out.println("#"+ num + "\n" + discipline +"\n");
            } else {
                System.out.println("#"+ num + "\n" + "Empty discipline space" + "\n");
            }
            num++;
        }

        System.out.print("Choose discipline to edit: ");
        int j = readInteger();
        try{
            SwimTime discipline = swimmerChosen.getDisciplines()[j-1];
            if(discipline!= null){
                System.out.println(discipline + "\n");

                System.out.print("Location name: ");
                String editLocation = readString();
                discipline.setLocation(editLocation);

                System.out.print("Date (date-month-year): ");
                LocalDate editDate = editDate(readString());
                discipline.setDate(editDate);

                System.out.println("""
                edit discipline
                1. Breaststroke
                2. Backstroke
                3. Butterfly
                4. Crawl""");

                System.out.print("Edit discipline: ");
                int choice = readInteger();

                String editDiscipline= "";
                while(editDiscipline.isBlank()){
                    switch (choice){
                        case 1 -> editDiscipline = "Breaststroke";
                        case 2 -> editDiscipline = "Backstroke";
                        case 3 -> editDiscipline = "Butterfly";
                        case 4 -> editDiscipline = "Crawl";
                        default -> System.out.println("Invalid input.. Choose again!");
                    }
                }
                discipline.setDisciplineName(editDiscipline);

                System.out.print("Swimmers time: ");
                double editTime = readDouble();
                discipline.setTime(editTime);

            } else {
                System.out.println("You need to add an discipline information first..\n");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No discipline found.. A competitor can have up till four disciplines registered");
            System.out.println("Try again press 0 | Exit press 1");
            int choice = readInteger();
            if (choice == 0){
                editDiscipline();
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

    public LocalDate editDate(String check){
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

        for (Member member : controller.getMembers()) {
            System.out.println(member);
        }
    }

    public void viewMembersWithPrice() {
        for (Member member : controller.getMembers()) {
            System.out.println(member.toString(2));
        }
    }

    public void sortTeamJunior() {
        for (Member member : controller.getListJunior()) {
            System.out.println(member);

        }
    }

    public void sortTeamSenior() {
        for (Member member : controller.getListSenior()) {
            System.out.println(member);
        }
    }
    public void sortCompJuniorSwimmers() {
        System.out.println(controller.getTeamJunior());
        for(Member member : controller.getMembers()) {
            if(controller.getListJunior().size() < 16 && member instanceof CompetitionSwimmer && member.getAge() < 18) {
                controller.getListJunior().add(member);
                sortTeamJunior();
            }
        }
    }

    public void sortCompSeniorSwimmer() {
        System.out.println(controller.getTeamSenior());
        for(Member member : controller.getMembers()) {
            if(controller.getListSenior().size() < 16 && member instanceof CompetitionSwimmer && member.getAge() >= 18) {
                controller.getListSenior().add(member);
                sortTeamSenior();
            }
        }
    }

/*    public void showCompJuniorSwimmers(){
        sortCompJuniorSwimmers();
        Team juniorSwimmers = controller.getTeamJunior();
        System.out.println("Swimmer list:");
        if(controller.getListJunior().isEmpty()){
            System.out.println("List is empty..");

        } else{
            System.out.println();
            for(Member teamMembers : juniorSwimmers.getTeam()){
                System.out.println("--------------------------------");
                System.out.println(teamMembers);
                System.out.println();
            }
        }
    }*/

    public int readInteger() {
        while (!sc.hasNextInt()) {
            System.out.println("This is not a number. Try again..");
            sc.next();
        }
        int i = sc.nextInt();
        sc.nextLine();
        return i;
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

    public String readString() {
        return sc.nextLine();
    }
    public Controller getController() {
        return controller;
    }
}



