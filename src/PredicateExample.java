import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("akash");
        names.add("praveen");
        names.add("Arun");
        names.add("Vivek");
        names.add("Anirudh");


        Predicate<String> p = name -> name.startsWith("A");
        List<String> filteredNames = filterNames(names, p);
        System.out.println("Names that start with 'A': " + filteredNames);

       /* String result = String.join(", ", filteredNames);
        System.out.println("Names that start with 'A': " + result);*/
    }

    public static List<String> filterNames(List<String> names, Predicate<String> condition) {
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (condition.test(name)) {
                filteredNames.add(name);
            }
        }
        return filteredNames;
    }
}
