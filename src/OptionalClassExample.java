import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalClassExample {
     Map<String, String> map = new HashMap<>();

    public OptionalClassExample() {
        map.put("Alice", "123 Main St, Wonderland");
        map.put("Bob", "456 Elm St, Dreamland");
    }
    public Optional<String> findAddressByName(String name) {
        String address = map.get(name);
        return Optional.ofNullable(address); // Wrap the address in an Optional
    }

    public static void main(String[] args) {
        OptionalClassExample addr = new OptionalClassExample();

        String searchName = "Akash";
        Optional<String> op = addr.findAddressByName(searchName);

        if (op.isPresent()) {
            String address = op.get();
            System.out.println("Address for " + searchName + ": " + address);
        } else {
            System.out.println(searchName + " not found in the address book.");
        }

    }
}
