class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pse=findPSE(heights);
        int[] nge=findNGE(heights);
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,heights[i]*(nge[i]-pse[i]-1));
        }
        return maxi;
    }

    public int[] findPSE(int[] arr){
        int n=arr.length;
        Stack<Integer> st= new Stack<>();
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
               st.pop();
            } 
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
     
    public int[] findNGE(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        return nge;
    }

}