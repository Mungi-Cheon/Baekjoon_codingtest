import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int coinTypes = sc.nextInt();
        int total = sc.nextInt();
        ArrayList<Integer> coins = new ArrayList<>();
        int coinCount = 0;

        for (int i = 0; i < coinTypes; i++) {
            coins.add(sc.nextInt());
        }

        while (total > 0) {
            int coin = coins.get(coins.size() - 1);
            coinCount += total / coin;
            total %= coin;

            coins.remove(Integer.valueOf(coin));
        }

        System.out.println(coinCount);
    }

}