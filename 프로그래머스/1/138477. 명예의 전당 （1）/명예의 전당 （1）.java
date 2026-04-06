import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] answer = new int[n];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            int s = score[i];
            if(pq.size()<k){
                pq.offer(s);
            }else{
                if(pq.peek() < s){
                    pq.poll();
                    pq.offer(s);
                }
            }
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}