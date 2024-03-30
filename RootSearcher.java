class RootSearcher {
    public static double f (double x) {
        return x * x * x + x + 1;
    }
    
    public static void main(String[] args) {
        double right   = 0;
        double left    = -1;
        double epsilon = 0.0001;
        double root    = 0;
  
        while ((right - left) > epsilon) {
            root = (right + left) / 2;

            if (f(right) * f(root) < 0) {
                left = root;
            }
            else right = root;
        }
    
        System.out.println("Корень: " + root);
    }
}
