class Solution {
    int res=0;
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void permute(int[] arr,int i){
        if(i==arr.length){
            res++;
        }
        for(int j=i;j<arr.length;j++){
            if((arr[j]%(i+1)==0 || (i+1)%arr[j]==0)){
                swap(arr,i,j);
                permute(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    public int countArrangement(int n) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++) arr[i-1]=i;
        permute(arr,0);
        return res;
    }
}