class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] nge=new int[n1];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i]==nums2[j]){
                    nge[i]=findNextGreater(nums2,j);

                }
            }
        }
        return nge;
    }

    public int findNextGreater(int[] nums2,int j){
        Stack<Integer> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        int n2=nums2.length;
        for(int i=n2-1;i>=j;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
               list.add(-1);
            }
            else{
                list.add(st.peek());
            }
            st.push(nums2[i]);
        }
        
        return list.get(list.size()-1);
    }
}