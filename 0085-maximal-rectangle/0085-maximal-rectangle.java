class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] preffixSum=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=Integer.parseInt(matrix[i][j]+"");
               if (matrix[i][j] == '0') {
                    preffixSum[i][j] = 0; 
                    sum = 0; 
                } else {
                    preffixSum[i][j] = sum; 
                }
            }
        }
        int maxi=0;
        for(int i=0;i<n;i++){
             maxi=Math.max(maxi, largest(preffixSum[i]));
        }
        return maxi;
    }

    public int largest(int[] arr){
       int n=arr.length;
       Stack<Integer> st=new Stack<>();
       int maxi=0;
       for(int i=0;i<n;i++){
         while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            int ele=st.peek();
            st.pop();
            int nse=i;
            int pse=st.isEmpty()?-1:st.peek();
            maxi=Math.max(maxi,arr[ele]*(nse-pse-1));
         }
         st.push(i);
       }
       while(!st.isEmpty()){
        int nse=n;
        int ele=st.peek();
        st.pop();
        int pse=st.isEmpty()?-1:st.peek();
        maxi=Math.max(maxi,arr[ele]*(nse-pse-1));
       }
       return maxi;
    }
}