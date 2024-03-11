import java.util.Scanner;

class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(double x2, double y2) {
        return Math.sqrt((x2 - this.x) * (x2 - this.x) + (y2 - this.y) * (y2 - this.y));
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        sc.close();

        Point A = new Point(x1, y1);
        Point B = new Point(x2, y2);

        System.out.format("%s -- строквое представление первой точки.\n", A.toString());
        System.out.format("%s -- строквое представление второй точки.\n", B.toString());
        System.out.format("Расстояние между точками: %.3f", A.distanceTo(x2, y2));
    }
}