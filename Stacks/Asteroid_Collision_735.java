class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            int curr=asteroids[i];
            while(!st.isEmpty() && st.peek()>0 && curr<0){
                int stTop=st.peek();
                if(stTop>(-1*curr)){
                    curr=0;
                    break;
                }
                else if(stTop<(-1*curr)){
                    st.pop();
                }
                else{
                    st.pop();
                    curr=0;
                    break;
                }
            }
            if(curr!=0) st.add(curr);
        }
        int[] res=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            res[i--]=st.pop();
        }
        return res;
    }
}