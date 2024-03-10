import java.util.Scanner;

class AreaUnderTheGraph {
    public static double f (double x) {
        return x * x * x + x + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        sc.close();

        double period = 0.001; 
        double k = 0.5;
        double x = 0;
        double y = 0;
        double area = 0;

        while (k * period < b - a) {
            x = a + k * period;
            y = f(x);
            area += period * y;
            k++;
        }
        
        System.out.format("%.3f", area);
    }
}
