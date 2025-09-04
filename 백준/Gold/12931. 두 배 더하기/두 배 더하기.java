import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        int count = 0;
        while (Arrays.stream(B).anyMatch(num -> num != 0)) {
            for (int i = 0; i < N; i++) {
                if (B[i] % 2 != 0) {
                    B[i] -= 1;
                    count++;
                }
            }
            if (Arrays.stream(B).anyMatch(num -> num != 0) && Arrays.stream(B)
                .allMatch(num -> num % 2 == 0)) {
                for (int j = 0; j < N; j++) {
                    B[j] /= 2;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}