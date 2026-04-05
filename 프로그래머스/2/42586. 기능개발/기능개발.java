import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int n = speeds.length;
        int[] days = new int[n];
        
        for(int i=0; i<n; i++){
            days[i] = (100-progresses[i]+speeds[i]-1)/speeds[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = days[0];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(max>=days[i]){
                count++;
            }else{
                list.add(count);
                max = days[i];
                count = 1;
            }
        }
        list.add(count);
        
        answer = list.stream()
            .mapToInt(i->i)
            .toArray();
        
        return answer;
    }
}