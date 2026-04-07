class TextEditor {
    StringBuilder sb;
    int c;
    public TextEditor() {
        sb=new StringBuilder();
        c=0;
    }
    
    public void addText(String text) {
        sb.insert(c,text);
        c+=text.length();
    }
    
    public int deleteText(int k) {
        int st=(k>c)?0:c-k;
        int r=c-st;
        sb.delete(st,c);
        c=st;
        return r;
    }
    
    public String cursorLeft(int k) {
        int st=(k>c)?0:c-k;
        c=st;
        String r=sb.substring(c-Math.min(10,c),c).toString();
        return r;
    }
    
    public String cursorRight(int k) {
        int end=(c+k>sb.length())?sb.length():c+k;
        c=end;
        String r=sb.substring(c-Math.min(10,c),c).toString();
        return r;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */