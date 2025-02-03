import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n > 0){
            if(n == 1){
                System.out.println(-1);
                return;
            }
            
            if (n % 5 == 0){
                cnt += n / 5;
                n %= 5;
            }else{
                n -= 2;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}