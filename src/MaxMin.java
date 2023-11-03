import java.util.*;
public class MaxMin {
    public static void main(String[] args) {
        Scanner griet=new Scanner(System.in);
        int n=griet.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            int a=griet.nextInt();
            list.add(a);

        }
        Optional<Integer> max=list.stream().max((x,y) -> x.compareTo(y));
        Optional<Integer> min=list.stream().min((x,y) -> x.compareTo(y));
        //list.stream().
        System.out.println("Maximum Value "+max.orElse(0));
        System.out.println("Minimum Value "+min.orElse(-1));
    }
}
