import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int n = nums.length / 2;
        int m = set.size();
        return n > m ? m : n;
    }
}