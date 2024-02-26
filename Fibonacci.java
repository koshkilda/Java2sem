import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        int a = 1;
        int b = 1;
        int c = 0;
        while (c < n) {
            c = a + b;
            a = b;
            b = c;
        }

        if (c == n || n == 1) {
            System.out.print(n + " является числом Фибоначчи");
        } else {
            System.out.print(n + " не является числом Фибоначчи");
        }
    }
}