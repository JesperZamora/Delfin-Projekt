import java.util.ArrayList;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> editMembers = new ArrayList<>();
    public void addExerciser(String name, int day, int month, int year, int phoneNumber, String address){
        members.add(new Exerciser(name, day, month, year, phoneNumber, address));
    }

    //TODO: not finished yet. Needs discipline information (future sprint)
    public void addCompetitionSwimmer(String name, int day, int month, int year, int phoneNumber, String adress){
        members.add(new Competition(name, day, month, year, phoneNumber, adress));
    }

    public void editMember(String name, int day, int month, int year, int phoneNumber, String adress, int memberChoice){
        if (!editMembers.isEmpty()){
            Member editMember = editMembers.get(memberChoice - 1);

            String newName = name;
            if (!newName.isEmpty()){
                editMember.setName(newName);
            }

            String newDay = Integer.toString(day);
            if (!newDay.isEmpty()){
                editMember.setDay(Integer.parseInt(newDay));
            }

            String newMonth = Integer.toString(month);
            if (!newMonth.isEmpty()){
                editMember.setMonth(Integer.parseInt(newMonth));
            }

            String newYear = Integer.toString(year);
            if (!newYear.isEmpty()){
                editMember.setYear(Integer.parseInt(newYear));
            }

            String newPhoneNumber = Integer.toString(phoneNumber);
            if (!newPhoneNumber.isEmpty()){
                editMember.setPhoneNumber(Integer.parseInt(newPhoneNumber));
            }

            String newAdress = adress;
            if (!newAdress.isEmpty()){
                editMember.setAddress(newAdress);
            }
        }
    }

    public Member searchMemberName(String searchName){
        for (Member m : members){
            if (m.getName().contains(searchName)){
                editMembers.add(m);
                return m;
            }
        }
        return null;
    }

    public Member searchMemberAge(String searchAge){
        for (Member m : members){
            String actualAge = Integer.toString(m.getAge());
            if (actualAge.contains(searchAge)){
                editMembers.add(m);
                return m;
            }
        }
        return null;
    }

    public Member searchMemberPhoneNumber(String searchPhoneNumber){
        for (Member m : members){
            String actualPhoneNumber = Integer.toString(m.getPhoneNumber());
            if (actualPhoneNumber.contains(searchPhoneNumber)){
                editMembers.add(m);
                return m;
            }
        }
        return null;
    }
}
