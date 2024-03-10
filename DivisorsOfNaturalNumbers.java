import java.util.Scanner;

class DivisorsOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i + " является делителем числа " + n);
            }
        }
    }
}
