class pair {
    String first;
    int second;
    pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new ArrayDeque<>();
        q.add(new pair(beginWord,1));
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        while(!q.isEmpty()){
            pair p=q.poll();
            String w=p.first;
            int len=p.second;

            if(w.equals(endWord))   return len;

            for(int i=0;i<w.length();i++){
                for(char c='a';c<='z';c++){
                    char[] arr=w.toCharArray();
                    arr[i]=c;
                    String newW=new String(arr);
                    if(set.contains(newW)){
                        set.remove(newW);
                        q.add(new pair(newW,len+1));
                    }
                }
            }
        }
        return 0;
    }
}