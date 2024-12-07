import java.util.*;

public class Main {
    static final String STOP_LINE = "0 0 0";
    static final String EQUILATERAL = "Equilateral";
    static final String ISOSCELES = "Isosceles";
    static final String SCALENE = "Scalene";
    static final String INVALID = "Invalid";
    
    static void solution(List<int[]> arr){
        for (int[] sizes : arr) {
            int a = sizes[0];
            int b = sizes[1];
            int c = sizes[2];

            if (a == b && b == c) {
                System.out.println(EQUILATERAL);
            } else if (a + b <= c || b + c <= a || a + c <= b) {
                System.out.println(INVALID);
            } else if (a != b && b != c && a != c) {
                System.out.println(SCALENE);
            } else {
                System.out.println(ISOSCELES);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<int[]> arr = new ArrayList<>();
        boolean isContinue = true;
        while (isContinue) {

            String line = sc.nextLine();
            if (STOP_LINE.equals(line)) {
                isContinue = false;
            } else {
                int[] sizes = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

                arr.add(sizes);
            }
        }

        solution(arr);
        sc.close();
    }
}