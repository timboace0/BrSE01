public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator != 0){
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            System.err.println("Mẫu số phải khác 0");
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        if(this.denominator != 0){
            this.numerator = numerator;
        } else {
            System.err.println("Mẫu số phải khác 0");
        }

    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction other){
        int newNumerator = this.numerator * other.denominator
                            + other.numerator * this.denominator;

        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator,newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator =
                this.numerator * other.denominator
                        - other.numerator * this.denominator;

        int newDenominator =
                this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator =
                this.numerator * other.numerator;

        int newDenominator =
                this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.err.println("Không thể chia cho phân số 0!");
        }

        int newNumerator =
                this.numerator * other.denominator;

        int newDenominator =
                this.denominator * other.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    @Override
    public String toString(){
        return numerator +  "/" + denominator;
    }
}
