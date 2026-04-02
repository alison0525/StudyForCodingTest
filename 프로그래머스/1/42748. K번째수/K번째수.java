import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        for(int[] command : commands){
            int i = command[0]-1;
            int j = command[1];
            int k = command[2]-1;
            
            List<Integer> list = new ArrayList<>();
            for(int x = i; x<j; x++){
                list.add(array[x]);
            }
            
            list.sort((a,b)->a-b);
            answer[idx++] = list.get(k);
        }
        return answer;
    }
}