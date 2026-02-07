public class ComputeMethods {
    
    public double fToC(double degreesF){
        return (degreesF-32)*5/9;
    }

    public double hypotenuse(int a, int b) {
        return Math.sqrt(a*a + b*b);
    }

    public int roll() {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        return dado1 + dado2;
    }
}  