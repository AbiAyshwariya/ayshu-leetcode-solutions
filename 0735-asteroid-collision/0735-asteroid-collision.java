class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // collision only when top > 0 and current < 0
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() < Math.abs(a)) {
                    st.pop();          // stack asteroid destroyed
                } 
                else if (st.peek() == Math.abs(a)) {
                    st.pop();          // both destroyed
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;  // current destroyed
                    break;
                }
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
