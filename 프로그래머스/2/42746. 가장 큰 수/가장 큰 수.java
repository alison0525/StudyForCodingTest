import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        
        Arrays.sort(strNums, (a,b)-> (b+a).compareTo(a+b));
        for(String s : strNums){
            answer+=s;
        }
        if(answer.charAt(0) == '0') return "0";   
        
        return answer;
    }
}