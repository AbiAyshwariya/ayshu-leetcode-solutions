class Solution {
    public long subArrayRanges(int[] nums) {
        return subarrayMax(nums)-subarrayMin(nums);
    }
    
    public long subarrayMin(int[] arr){
        int n=arr.length;
        int[] pse=findPSE(arr);
        int[] nse=findNSE(arr);
        long total=0;
        
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }
    public long subarrayMax(int[] arr){
        int n=arr.length;
        int[] pge=findPGE(arr);
        int[] nge=findNGE(arr);
        long total=0;
        System.out.println(Arrays.toString(pge));
        System.out.println(Arrays.toString(nge));

        for(int i=0;i<n;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }
    
    public int[] findPSE(int[] nums){
        int n=nums.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
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

    public int[] findNSE(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;

    }

    public int[] findPGE(int[] nums){
        int n=nums.length;
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }
            else{
                pge[i]=st.peek();
            }
            st.push(i);
        }
        return pge;
    }

    public int[] findNGE(int[] nums){
      int n=nums.length;
      int[] nge=new int[n];
      Stack<Integer> st=new Stack<>();
      for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
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