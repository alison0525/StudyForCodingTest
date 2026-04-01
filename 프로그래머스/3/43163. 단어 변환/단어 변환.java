import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        List<String> list = new ArrayList<>();
        
        list.add(begin);
        list.addAll(Arrays.asList(words));
        
        boolean[] visited = new boolean[list.size()];
        
        boolean b = false;
        for(String s : words){
            if(s.equals(target)) b = true;
        }
        if(!b) return 0;
        
        dfs(list, visited, target, 0, 0);
        
        
        
        return answer;
    }
    
    public void dfs(List<String> list ,boolean[] visited, String target, int index, int step){
        if(list.get(index).equals(target)){
            answer = answer>step ? step : answer;
            return;
        }
        
        for(int i = 0; i<list.size(); i++){
            if(!visited[i] && canChange(list.get(index), list.get(i))){
                visited[i] = true;
                dfs(list, visited, target, i, step+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canChange(String s1, String s2){
        int count = 0;
        
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        
        return count == 1 ? true : false;
    }
}