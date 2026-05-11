class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int n:nums){
            String s=String.valueOf(n);
            for(char c:s.toCharArray()) res.add(c-'0');
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}