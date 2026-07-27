class NumArray {
    int[] arr;
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        seg = new int[4*n];
        build(0, n-1, 0);
    }
    public void build(int l, int r, int i){
        if(l == r){
            seg[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        build(l, mid, 2*i+1);
        build(mid+1, r, 2*i+2);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public void up(int l, int r, int i, int idx, int val){
        if(l == r) {
            arr[idx] = val;
            seg[i] = val;
            return;
        }
        int mid = l + (r-l)/2;
        if(idx <= mid)  up(l, mid, 2*i+1, idx, val);
        else up(mid+1, r, 2*i+2, idx, val);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public int query(int l, int r, int ql, int qr, int i){
        if(l > qr || r < ql) return 0;
        if(l >= ql && r <= qr) return seg[i];
        int mid = l + (r-l)/2;
        return query(l, mid, ql, qr, 2*i+1) + query(mid+1, r, ql, qr, 2*i+2);
    }
    public void update(int index, int val) {
        up(0, n-1, 0, index, val);
    }
    
    public int sumRange(int left, int right) {
        return query(0, n-1, left, right, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna