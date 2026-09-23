import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<>();

        String[] p = path.split("/");

        for (String part: p) {
            if(part.equals("") || part.equals(".")) {
                continue;
            }

            if(part.equals("..")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(part);
            }
        }

        StringBuilder res = new StringBuilder();

        for(String f: st) {
            res.append("/");
            res.append(f);
        }

        if(res.length()==0) {
            return "/";
        }

        return res.toString();
    }
}