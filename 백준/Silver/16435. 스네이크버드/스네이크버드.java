import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] HList = new int[N];
        for (int i = 0; i < N; i++) {
            HList[i] = sc.nextInt();
        }

        Arrays.sort(HList);

        for (int i = 0; i < N; i++) {
            if (L >= HList[i]) {
                L++;
            }
        }
        System.out.println(L);
    }
}