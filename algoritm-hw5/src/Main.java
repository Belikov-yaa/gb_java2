public class Main {
    public static void main(String[] args) {
        System.out.println(recExponentiation(2,8));
    }

    public static long recExponentiation(int base, int exp) {
        if (exp == 1) return base;
        return base * recExponentiation(base, exp - 1);
    }
}
