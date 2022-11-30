import java.util.ArrayList;

public class Team {
    Controller controller = new Controller();
    private ArrayList<Member> compMembersUnder18 = new ArrayList<>();
    private ArrayList<Member> compMembersOver18 = new ArrayList<>();

    public Team(Trainer trainer, Competition competition){

    }
    public void sortCompMembersAge() {
        for (Member member : controller.getMembers()) {
            if (member.getMembershipType().equals("comp swimmer") && member.getAge() < 18) {
                compMembersUnder18.add(member);


            } else if (member.getMembershipType().equals("comp swimmer") && member.getAge() >= 18) {
                compMembersOver18.add(member);

            }
        }
    }

    public ArrayList<Member> getCompMembersUnder18() {
        return compMembersUnder18;

    }
    public ArrayList<Member> getGetCompMembersOver18() {
        return compMembersOver18;
    }
}

