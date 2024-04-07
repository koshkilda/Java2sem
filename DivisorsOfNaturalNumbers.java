import java.util.Scanner;

class DivisorsOfNaturalNumbers {
    public static int number_of_divisors(int n) {
        int number_of_divisors = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                number_of_divisors++;
            }
        }
        
        return number_of_divisors;
    }
    
    
    public static int divisors_power(int divisor, int number) {
        int divisors_power = 1;
    
        while (number / Math.pow(divisor, divisors_power) % divisor == 0) {
            divisors_power++;
        }
        
        return divisors_power;
    } 
    
    
    public static void main(String[] args) {
        System.out.println("Введите число до 99999999");
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (number_of_divisors(i) == 2) {
                    System.out.println(i + "^" + divisors_power(i, n) + " является простым множителем числа " + n);
                }
            }
        }
    }
}
