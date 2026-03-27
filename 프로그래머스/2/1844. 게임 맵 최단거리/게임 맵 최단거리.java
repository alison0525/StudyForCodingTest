import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int[][] dist = new int[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        dist[0][0] = 1;
        visited[0][0] = true;
        queue.offer(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1]; 
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                    
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                    
                    
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
            
        }
        
        return answer = dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}