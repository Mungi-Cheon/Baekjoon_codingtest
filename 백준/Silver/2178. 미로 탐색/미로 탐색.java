import java.awt.Point;
import java.util.*;

public class Main{
    
    static int[][] maps;
    
    static int bfs(int x, int y){
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new Point(x, y));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            
            if(cur.x == n - 1 && cur.y == m - 1){
                return maps[n - 1][m - 1];
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                    continue;
                }
                
                if(maps[nextX][nextY] == 0){
                    continue;
                }
                
                if(visited[nextX][nextY]){
                    continue;
                }
                
                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
                maps[nextX][nextY] = maps[cur.x][cur.y] + 1;
            }
        }
        return maps[n - 1][m - 1];
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] size = sc.nextLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        maps = new int[n][m];
        
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){    
                maps[i][j] = line.charAt(j) - '0';
            }           
        }
        System.out.println(bfs(0, 0));
    }
}