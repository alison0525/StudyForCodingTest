import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int n : arr){
            if(stack.isEmpty() || stack.peek() != n){
                stack.push(n);
                list.add(n);
            }
        }
        
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }
}