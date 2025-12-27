class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nge=findNGE(arr);
        int[] pse=findPSE(arr);

        int mod=(int)(1e9+7);
        long total=0;

        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nge[i]-i;
            long contribution = (long) left * right % mod * arr[i] % mod;
            total = (total + contribution) % mod;
        }
       return (int)total;
    }

    public int[] findNGE(int[] arr){
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
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

    public int[] findPSE(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
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
}