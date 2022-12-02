import java.util.Comparator;

//TODO At lave vores comparator om til tid. (Kræver en getter til tid)
public class TimeComparator implements Comparator<Member> {
    public int compare(Member m1, Member m2){
        return m1.getAge() - m2.getAge();
    }
}
