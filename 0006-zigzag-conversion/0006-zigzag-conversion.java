class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||numRows>=s.length()) return s;
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) rows[i]=new StringBuilder();
        int row=0;
        boolean goingDown=false;
        for(char c:s.toCharArray()){
            rows[row].append(c);
            if(row==0||row==numRows-1) goingDown = !goingDown;
            row+= goingDown?1:-1;
        }

        StringBuilder res=new StringBuilder();
        for(int i=0;i<numRows;i++){
            res.append(rows[i]);
        }
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna