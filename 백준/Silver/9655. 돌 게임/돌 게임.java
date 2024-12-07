import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dpList = new int[1001];
        
        dpList[0] = 0;
        dpList[1] = 1;
        dpList[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dpList[i] = Math.min(dpList[i - 1] + 1, dpList[i - 3] + 1);
        }
        
        if(dpList[n] % 2 == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}