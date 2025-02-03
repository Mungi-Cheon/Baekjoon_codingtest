import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 1 2 3 3 4 -> (1) + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4) -> 1+ 3 + 6 + 9 + 13 -> 32 min
            sum[i] = sum[i - 1] + arr[i];
        }

        System.out.println(Arrays.stream(sum).sum());
    }
}