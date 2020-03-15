package com.company;

import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

public class FP {


    private static Object Integer;

    public static void main(String[] args)
    {
       List<Integer> input = Arrays.asList(new Integer[]{1, 2, 3});
       List<Integer> inputB = Arrays.asList(new Integer[]{4,5,6});


       System.out.println(String.format("Sum: %s", sum.apply(input)));
       System.out.println(append.apply(input, inputB));
       System.out.println(doubles.apply(3));

       //

        Integer output = Functionals.foldr(new Functions<Integer, Integer>() {

            @Override
            public Integer call( Integer t1,  Integer t2) {
                return t1 + t2;
            }
        }, 0, input);


      //  System.out.println("Sums: " + sums(datas));

      //  System.out.println("double : "+ map(datas, n->n*2));



      /*  long start = System.currentTimeMillis();
        printIfValidIndex(0, getVeryExpensiveValue());
        printIfValidIndex(-1, getVeryExpensiveValue());
        printIfValidIndex(-2, getVeryExpensiveValue());


        System.out.println("It took " + (System.currentTimeMillis() - start) / 1000 + " seconds");

        long startSupplier = System.currentTimeMillis();
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> getVeryExpensiveValue());


        System.out.println("It took " + (System.currentTimeMillis() - startSupplier) / 1000 + " seconds");*/
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "abc";
    }

    private static void printIfValidIndex(int num, String value) {
        if (num >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("invalid");
        }
    }

    private static void printIfValidIndex(int num, Supplier<String> valueSupplier) {
        if (num >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }


    private static Function<List<Integer>, Integer> sum = l -> foldr((x, y) -> x + y, 0, l);
    private static BinaryOperator<List<Integer>> append = (a,b)->foldr((x,l)-> new Cons(x, l).cons(), b, a);
    private static Function<Integer, Integer> doubles = n -> 2*n;





    public static <T, U> U foldr(BiFunction<T, U, U> f, U x, List<T> list) {
        if(list.isEmpty()) {
            return x;
        }
        T a = list.get(0);
        List<T> l = list.subList(1, list.size());
        return f.apply(a, foldr(f, x, l));
    }

}







