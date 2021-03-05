import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCheckTest {
    ArrayList<Integer> NumberList = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void randomNUmberGenerator() {
        Random ran = new Random();
        for (int i = 0 ; i < 100 ; i++)
        {
            NumberList.add(ran.nextInt(1000));

        }

       assert (!NumberList.isEmpty());



        for (int i=0;i<100;i++) {
            assert (NumberList.get(i)>0);
        }
        assert (NumberList.get(5)<1000);
    }
    static Predicate<Integer> CHeckWhetherPrime = number->number>1 && LongStream.rangeClosed(2, number / 2).
            noneMatch(i -> number % i == 0);

    @org.junit.jupiter.api.Test
    void primeGenerator() {
        Random ran = new Random();
        for (int i = 0 ; i < 100 ; i++)
        {
            NumberList.add(ran.nextInt(1000));

        }
        List<Integer> PrimeNumber= NumberList.stream().filter(CHeckWhetherPrime).collect(Collectors.toList());

        for(int i=0;i<100;i++)
        {
            if(NumberList.get(i).equals(PrimeNumber))
            {
                assert (true);
            }
        }
    }
}