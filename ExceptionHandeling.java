package practicals;

import java.util.Scanner;

public class ExceptionHandeling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number ");
        int num1 = sc.nextInt();
        System.out.println("Enter Second Number");
        int num2 = sc.nextInt();
        try{
            int result = num1 / num2 ;
            System.out.println("The Division is " + result);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage() + "is Not allowedin Java");
        }
    }
}
