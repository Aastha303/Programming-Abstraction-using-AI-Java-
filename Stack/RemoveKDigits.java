import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        if(k==0 || num==null){
            return num;
        }
        Stack<Character>st=new Stack<>();

        for(int i=0;i<num.length();i++){
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i)){
                k--;
                st.pop();
            }
            st.push(num.charAt(i));

        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());

        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0'){

            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            return "0";
        }

        return sb.toString();
        
        
    }
}