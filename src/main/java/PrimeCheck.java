import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PrimeCheck {
    public static void main(String[] args) {
        ArrayList<Integer> InputData = randomNUmberGenerator();
        PrimeGenerator(InputData);
    }
    static ArrayList<Integer> randomNUmberGenerator() {
        ArrayList<Integer> NumberList = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++)
        {   Random ran = new Random();
            NumberList.add(ran.nextInt(1000));

        }
       //System.out.println(NumberList);
        return NumberList;
    }
    static Predicate<Integer> CHeckWhetherPrime = number->number>1 && LongStream.rangeClosed(2, number / 2).
            noneMatch(i -> number % i == 0);

    static void PrimeGenerator(ArrayList<Integer> Array_List){
        List<Integer> PrimeNumber= Array_List.stream().filter(CHeckWhetherPrime).collect(Collectors.toList());
        System.out.println("prime number randomly generated");
        System.out.println(PrimeNumber);
    }
}
