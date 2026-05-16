package Array;

import java.util.*;

public class PowXtoN{

    public double Power(double x, int n){
    double result = Math.pow(x, n);
    return result;  
    }



    public static void main(String[] args) {
         System.out.print("Enter the base (x): ");
        Scanner sc = new Scanner(System.in);
       
        double x = sc.nextDouble();
        System.out.println("Enter the exponent (n): ");
        int n = sc.nextInt();

        System.out.println(new PowXtoN().Power(x, n));


    }
} 