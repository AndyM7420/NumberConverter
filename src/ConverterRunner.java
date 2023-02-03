import java.util.Scanner;
import java.util.Arrays;

public class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");

        System.out.print("Enter the base of your number (2, 8, 10 or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        System.out.println("Enter your other base to convert from Base 10:");
        String otherChoice=s.nextLine();
        int otherBase=Integer.parseInt(otherChoice);
        if(choice.equals("16")){
            int base = Integer.parseInt(choice);
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            s.close();
            NumberConverter nc = new NumberConverter(number, base,otherBase);
            if(nc.restrictHexa(number)){
                int[] digits = nc.getDigits();
                System.out.println("\nDigit array: " + Arrays.toString(digits));
                System.out.println("Number: " + nc.displayOriginalNumber());
                System.out.println(nc.displayConvertedNumber());
            }else{
                System.out.println("NOT APPLICABLE IN THIS BASE. TRY AGAIN");
            }
        }else{
        int base = Integer.parseInt(choice);
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);
        s.close();
        NumberConverter nc = new NumberConverter(n, base,otherBase);
        if(nc.restrict(n,base)){
            int[] digits = nc.getDigits();
            System.out.println("\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            System.out.println(nc.displayConvertedNumber());
        }else{
            System.out.println("NOT APPLICABLE IN THIS BASE. TRY AGAIN");
        }
    }
}}