class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
             res=res.append(st.peek());
             st.pop();
        }

        while(res.length()!=0 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }
        res.reverse();
        if(res.isEmpty()){
            return "0";
        }
        return res.toString();
         
        
    }
}