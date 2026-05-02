class Solution {
    public int rotatedDigits(int n) {
        boolean[] valid=new boolean[]{true,true,true,false,false,true,true,false,true,true};
        int res=0;
        for(int i=1;i<=n;i++){
            boolean flag=true;
            boolean contains=false;
            int temp=i;
            while(temp>0){
                int l=temp%10;
                if(!valid[l]){
                    flag=false;
                    break;
                }
                if(l==2 || l==5 || l==6 || l==9) contains=true;
                temp/=10;
            }
            if(flag && contains) res++;
        }
        return res;
    }
}