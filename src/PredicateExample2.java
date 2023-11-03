import java.util.ArrayList;
import java.util.function.Predicate;

class Employee2 {
    private final int id;
    private final String name;
    private final int age;

    Employee2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return "Name: "+name+" Age: "+age+" Id: "+id;
    }
}

class PredicateExample2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Employee2> list = new ArrayList<>();
        list.add(new Employee2(101, "Sachin", 40));
        list.add(new Employee2(102, "Kohli", 33));
        list.add(new Employee2(103, "Dhoni", 38));
        list.add(new Employee2(104, "Raina", 38));
        list.add(new Employee2(105, "Rahul", 28));
        list.add(new Employee2(104, "Rohit", 33));
        list.add(new Employee2(105, "Gill", 23));

        System.out.println(list);  //printing all list objects at a time

        for (Employee2 c: list) {
            System.out.println(c);       //accessing each object seprately
        }
        Predicate<Integer> p = i -> i < 30;
        ArrayList<String> res = new ArrayList<>();
        for (Employee2 i : list) {
            if (p.test(i.getAge()))
                res.add(i.getName());
        }
        System.out.println(res);

        /*for (String e:res)
            System.out.println(e);*/
    }

}