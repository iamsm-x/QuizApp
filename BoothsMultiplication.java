import java.util.Scanner;

public class BoothsMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter multiplicand (A): ");
        int multiplicand = sc.nextInt();

        System.out.print("Enter multiplier (B): ");
        int multiplier = sc.nextInt();

        
        int n = Math.max(Integer.toBinaryString(Math.abs(multiplicand)).length(),
                         Integer.toBinaryString(Math.abs(multiplier)).length()) + 1;

        System.out.println("\nBooth's Multiplication Process:");
        System.out.println("--------------------------------");

        int A = multiplicand;
        int S = -multiplicand;
        int P = (multiplier << n) | 0; 

        System.out.printf("Initial P: %s\n", toBinary(P, 2 * n + 1));

        for (int i = 0; i < n; i++) {
            int lastTwoBits = P & 0b11; 

            if (lastTwoBits == 0b01) {
                P = P + (A << (n + 1));
                System.out.printf("Step %d: Add A → %s\n", i + 1, toBinary(P, 2 * n + 1));
            } else if (lastTwoBits == 0b10) {
                P = P + (S << (n + 1));
                System.out.printf("Step %d: Sub A → %s\n", i + 1, toBinary(P, 2 * n + 1));
            }

            
            P = arithmeticShiftRight(P, 2 * n + 1);
            System.out.printf("After ASR: %s\n", toBinary(P, 2 * n + 1));
        }

        
        int product = P >> 1;
        System.out.println("\nFinal Product (Decimal): " + product);
        System.out.println("Final Product (Binary): " + toBinary(product, 2 * n));
    }

    
    public static int arithmeticShiftRight(int value, int bits) {
        int sign = (value >> (bits - 1)) & 1;
        value >>= 1;
        if (sign == 1)
            value |= (1 << (bits - 1));
        return value;
    }

    
    public static String toBinary(int num, int bits) {
        String s = Integer.toBinaryString(num & ((1 << bits) - 1));
        while (s.length() < bits) s = "0" + s;
        return s;
    }
}
