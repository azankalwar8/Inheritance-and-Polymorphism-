public class MultiCalc extends Simplecalc {
    public void calculate() {
        value -= 3;
    }

    public void calculate(int multipier) {
        calculate();
        super.calculate();
        value *= multipier;
    }

    public static void main(String[] args) {
        MultiCalc calculator = new MultiCalc();
        calculator.calculate(2);
        System.out.print("Value is: " + calculator.value);
    }
}
