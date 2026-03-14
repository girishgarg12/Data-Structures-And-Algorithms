
class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    List<List<String>> res=new ArrayList<>();
    String b;
    public void dfs(String word,List<String> list){
        if(word.equals(b)){
            Collections.reverse(list);
            res.add(new ArrayList<>(list));
            Collections.reverse(list);
        }
        int steps=map.get(word);
        int sz=word.length();
        for(int i=0;i<sz;i++){
            for(char ch='a';ch<='z';ch++){
                char[] arr=word.toCharArray();
                arr[i]=ch;
                String nw=new String(arr);

                if(map.containsKey(nw) && map.get(nw)+1==steps){
                    list.add(nw);
                    dfs(nw,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q=new ArrayDeque<>();
        q.add(beginWord);
        b=beginWord;
        HashSet<String> set=new HashSet<>();
        for(String s:wordList)  set.add(s);
        map.put(beginWord,1);
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.poll();
            int len=map.get(word);
            int sz=word.length();
            if(word.equals(endWord))    break;
            for(int i=0;i<sz;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String nw=new String(arr);
                    if(set.contains(nw)){
                        q.add(nw);
                        set.remove(nw);
                        map.put(nw,len+1);
                    }
                }
            }
        }
        if(map.containsKey(endWord)){
            List<String> list=new ArrayList<>();
            list.add(endWord);
            dfs(endWord,list);
        }
        return res;
    }
}