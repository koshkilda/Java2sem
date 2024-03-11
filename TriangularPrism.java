import java.util.Scanner;

class TriangularPrism {
    double a;
    double b;
    double c;
    double h;

    public TriangularPrism(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    public double wallArea(double m, double h) {
        return m * h;
    }

    public double volume(double a, double b, double c, double h) {
        double p = (a + b + c) / 2;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p -c ));
        return S * h;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double h = sc.nextDouble();
        sc.close();

        TriangularPrism prism = new TriangularPrism(a, b, c, h);
        
        System.out.println("Параметры призмы: " + a + ", " + b + ", " + c + " -- длины сторон основания, " + h + " -- высота.");
        System.out.println(prism.wallArea(a, h) + " -- площадь боковой поверхности на " + a + ".");
        System.out.println(prism.wallArea(b, h) + " -- площадь боковой поверхности на " + b + ".");
        System.out.println(prism.wallArea(c, h) + " -- площадь боковой поверхности на " + c + ".");
        System.out.format("%.3f -- объем призмы.", prism.volume(a, b, c, h));
    }
}
