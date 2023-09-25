package project.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        BigInteger sum = fib(n).add(fib(n - 1));
        BigInteger pow = new BigInteger(String.valueOf((int) Math.pow(10, k)));
        if (pow.compareTo(sum) > 0) {
            System.out.print(sum);
        } else {
            System.out.print(sum.mod(pow));
        }
        BeanException e;
    }

    static BigInteger fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;
        return BigDecimal.valueOf(phi).pow(n).subtract(BigDecimal.valueOf(psi).pow(n))
                .divide(BigDecimal.valueOf(sqrt5), RoundingMode.CEILING).toBigInteger();
    }


}
