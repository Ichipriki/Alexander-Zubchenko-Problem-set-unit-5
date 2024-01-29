public class Fraction {

    private int numerator = 1;
    private int denominator = 1;

    //Default
    public Fraction (){
        this.numerator = 1;
        this.denominator = 1;
    }

    //Two params
    public Fraction (int numerator, int denominator){
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    //String param
    public Fraction (String fraction){
        for (int i = 0; i < fraction.length(); i++) {
            if (fraction.charAt(i) == '/') {
                numerator = Integer.parseInt(fraction.substring(0, i));
                denominator = Integer.parseInt(fraction.substring(i+1));
            }
        }
    }

    //Fraction param
    public Fraction (Fraction fraction){
        if (fraction.getDenom() != 0) {
            numerator = fraction.getNum();
            denominator = fraction.getDenom();
        }
    }
    public int getNum(){
        return numerator;
    }
    public void setNum(int x){
        numerator = x;
    }

    public int getDenom(){
        return denominator;
    }
    public void setDenom(int x){
        denominator = x;
    }

    public String toString(){
        return numerator+"/"+denominator;
    }

    public double toDouble(){
        return (double)numerator/denominator;
    }

    public int factor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            }
        }
        return a;
    }

    public void reduceFrac(){
        int fact = factor(numerator, denominator);
        numerator /= fact;
        denominator /= fact;
        if (numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        if (numerator > 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public static Fraction add(Fraction first, Fraction second) {
        int denom = first.getDenom() * second.getDenom();
        Fraction result = new Fraction(((first.getNum()*second.getDenom())+(second.getNum()*first.getDenom())), denom);
        result.reduceFrac();
        return result;
    }

    public static Fraction subtract(Fraction first, Fraction second) {
        int denom = first.getDenom() * second.getDenom();
        Fraction result = new Fraction(((first.getNum()*second.getDenom())-(second.getNum()*first.getDenom())), denom);
        result.reduceFrac();
        return result;
    }

    public static Fraction multiply(Fraction first, Fraction second) {
        Fraction result = new Fraction((first.getNum() * second.getNum()), (first.getDenom() * second.getDenom());
        result.reduceFrac();
        return result;

    }

    public static Fraction divide(Fraction first, Fraction second) {
        Fraction result = new Fraction((first.getNum() * second.getDenom()), (first.getDenom() * second.getNum());
        result.reduceFrac();
        return result;
    }
}
