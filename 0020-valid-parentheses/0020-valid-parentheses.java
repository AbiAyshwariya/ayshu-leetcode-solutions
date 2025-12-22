class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2!=0){
            return false;
        }
        Stack<Character> st=new Stack<>();
        boolean result=false;
        for(int i=0;i<n;i++){
            
            char ch=s.charAt(i);
            if(ch=='{'||ch=='('||ch=='['){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                char ans=st.peek();
                
                if(ans=='{' && ch=='}'){
                    st.pop();
                }
                else if(ans=='(' && ch==')'){
                    st.pop();
                }
                else if(ans=='[' && ch==']'){
                    st.pop();
                }
                else{
                   result=false;
                   return result;
                }
                }
                else{
                    return false;
                }
            }
            }
            if(!st.isEmpty()){
                result=false;
            }
            else{
                result=true;
            }
        return result;
    }
}