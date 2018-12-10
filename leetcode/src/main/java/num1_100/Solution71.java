package num1_100;

import java.util.Stack;

/**
 * 71. 简化路径
 */
class Solution71 {
    public String simplifyPath(String path) {
        if (path == null || "".equals(path)) {
            return path;
        }
        String[] paths = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            switch (s){
                case "..":
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                case ".":
                    break;
                case "" :
                    break;
                default:
                    stack.push("/" + s);
                    break;
            }
        }

        if (stack.isEmpty()) {
            return "/";
        } else {
            String simplifyPath = "";
            while (!stack.isEmpty()) {
                simplifyPath = stack.pop() + simplifyPath;
            }
            return simplifyPath;
        }
    }

}