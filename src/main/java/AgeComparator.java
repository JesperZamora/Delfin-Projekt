import java.util.Comparator;

public class AgeComparator implements Comparator<Member> {
    public int compare(Member m1, Member m2) {
return  Integer.compare(m1.getAge(), m2.getAge());

    }
}
