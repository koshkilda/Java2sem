import java.util.Scanner;

class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double scalarMultiplication(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }
    
    public Vector vectorAddition(Vector vector) {
         
        double a = this.x + vector.x;
        double b = this.y + vector.y;
        double c = this.z + vector.z;
        Vector add = new Vector(a, b, c);
        
        return add;
    }
    
    public Vector vectorSubtraction(Vector vector) {
         
        double a = this.x - vector.x;
        double b = this.y - vector.y;
        double c = this.z - vector.z;
        Vector sub = new Vector(a, b, c);
        
        return sub;
    }
    
    public Vector vectorMultiplication(Vector vector) {
        
        double a = this.y * vector.z - this.z * vector.y;
        double b = this.z * vector.x - this.x * vector.z;
        double c = this.x * vector.y - this.y * vector.x;
        Vector multi = new Vector(a, b, c); 
        
        return multi;
    }
    
    public double angleBetweenVectors(Vector vector) {      
        return (this.scalarMultiplication(vector) / (this.vectorLength() * vector.vectorLength()));
    }
    
    public double vectorLength() {      
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double areaParallelogram(Vector vector) {      
        return this.vectorMultiplication(vector).vectorLength();
    } 
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Вводите все данные в правом ОНБ базисе.");
        System.out.println("Введите координаты первого вектора: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        Vector vc1 = new Vector(x, y, z);
        
        System.out.println("Введите координаты второго вектора: ");
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();
        Vector vc2 = new Vector(x, y, z);
        
        sc.close();
        
        System.out.println("Скалярное произведение векторов: " + vc1.scalarMultiplication(vc2));
        System.out.println("Координаты вектора -- суммы векторов: " + "(" + vc1.vectorAddition(vc2).x + ", " + vc1.vectorAddition(vc2).y + ", " + vc1.vectorAddition(vc2).z + ")");
        System.out.println("Координаты вектора -- разности векторов: " + "(" + vc1.vectorSubtraction(vc2).x + ", " + vc1.vectorSubtraction(vc2).y + ", " + vc1.vectorSubtraction(vc2).z + ")");
        System.out.println("Координаты вектора -- произведения векторов: " + "(" + vc1.vectorMultiplication(vc2).x + ", " + vc1.vectorMultiplication(vc2).y + ", " + vc1.vectorMultiplication(vc2).z + ")");
        System.out.println("Угол между векторами: " + vc1.angleBetweenVectors(vc2));
        System.out.println("Длина первого вектора: " + vc1.vectorLength() + ", длина второго вектора: " + vc2.vectorLength());
        System.out.println("Площадь параллелограмма, основанного на заданных векторах: " + vc1.areaParallelogram(vc2)); 
    }
}
