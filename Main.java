import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        game();
    }

    public static Fraction findPi(){
        Fraction milu = new Fraction(355, 113);
        Fraction test = new Fraction(355, 113);
        final double epsilon = Math.abs( Math.PI - milu.toDouble());

        while (Math.abs(Math.PI - test.toDouble()) >= epsilon){
            if (test.toDouble() > Math.PI){
                test.setNum(test.getNum()+1);
            } else if (test.toDouble() < Math.PI){
                test.setDenom(test.getDenom()+1);
            }
        }
        //test.reduceFrac();
        return test;
    }

    public static void game(){
        int wins = 0;
        int losses = 0;
        int winslosses = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);

            int signSpin = (int) (Math.random()*4) + 1;
            String sign = "";
            Fraction a = new Fraction((int)(Math.random()*9) + 1, (int)(Math.random()*9) + 1);
            Fraction b = new Fraction((int)(Math.random()*9) + 1, (int)(Math.random()*9) + 1);
            Fraction answer;
            if (signSpin == 1){
                sign = "+";
                answer = Fraction.add(a, b);
            } else if (signSpin == 2){
                sign = "-";
                answer = Fraction.subtract(a, b);
            } else if (signSpin == 3){
                sign = "/";
                answer = Fraction.divide(a, b);
            } else {
                sign = "*";
                answer = Fraction.multiply(a, b);
            }
            System.out.println(a + " " + sign + " " + b + " = ");
            String input = scanner.nextLine();
            if (input.equals("quit") || input.equals("end") || input.equals("exit")) break;
            Fraction answerInput = new Fraction(input);
            if (answer.getNum() == answerInput.getNum() && answer.getDenom() == answerInput.getDenom()){
                System.out.println("WIN");
                System.out.println("Correct answer:" +  answer);
                wins++;
            } else {
                System.out.println("LOSE");
                System.out.println("Correct answer:" +  answer);
                losses++;
            }

            System.out.println("WINS:" + wins + "/" + losses);
        }
    }
}
