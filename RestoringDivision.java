import java.util.Scanner;

public class RestoringDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Dividend (Q): ");
        int Q = sc.nextInt();

        System.out.print("Enter Divisor (M): ");
        int M = sc.nextInt();

        
        int n = Math.max(Integer.toBinaryString(Math.abs(Q)).length(),
                         Integer.toBinaryString(Math.abs(M)).length()) + 1;

        int A = 0; 
        System.out.println("\nRestoring Division Process:");
        System.out.println("----------------------------------");

        for (int i = 0; i < n; i++) {
            
            A = (A << 1) | ((Q >> (n - 1)) & 1);
            Q = (Q << 1);

            System.out.printf("Step %d:\n", i + 1);
            System.out.printf("After Left Shift → A: %s, Q: %s\n",
                    toBinary(A, n), toBinary(Q, n));

            
            A = A - M;
            System.out.printf("A = A - M → %s\n", toBinary(A, n));

            
            if (A < 0) {
                Q = Q & (~1); 
                A = A + M; 
                System.out.printf("A < 0 → Restore A = A + M → %s, Q0 = 0\n", toBinary(A, n));
            } else {
                Q = Q | 1; 
                System.out.printf("A ≥ 0 → Keep A → %s, Q0 = 1\n", toBinary(A, n));
            }
            System.out.println("----------------------------------");
        }

        System.out.println("\nFinal Results:");
        System.out.println("Quotient (Q):  " + Q + "  →  " + toBinary(Q, n));
        System.out.println("Remainder (A): " + A + "  →  " + toBinary(A, n));
    }

    
    public static String toBinary(int num, int bits) {
        String s = Integer.toBinaryString(num & ((1 << bits) - 1));
        while (s.length() < bits) s = "0" + s;
        return s;
    }
}
