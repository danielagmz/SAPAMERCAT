import java.util.Comparator;

public class CompararAlimentacio implements Comparator<Alimentacio> {
    @Override
    public int compare(Alimentacio o1, Alimentacio o2) {
        if (o1.getPreu()>o2.getPreu()){
            return 1;
        } else if (o2.getPreu()<o2.getPreu()) {
            return -1;
        }
        return 0;
    }
}
