import java.util.*;

public class ParenthesisMatcher {
    
    /**
     * 判斷字串中的括號是否合法配對
     * @param s 輸入字串，只包含 '(', ')', '{', '}', '[', ']'
     * @return true 或 false
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 如果是左括號，推入堆疊
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // 如果是右括號
            else if (c == ')' || c == '}' || c == ']') {
                // 堆疊為空，沒有對應的左括號
                if (stack.isEmpty()) {
                    return false;
                }
                
                char left = stack.pop();
                
                // 檢查是否配對
                if (c == ')' && left != '(') {
                    return false;
                }
                if (c == '}' && left != '{') {
                    return false;
                }
                if (c == ']' && left != '[') {
                    return false;
                }
            }
        }
        
        // 堆疊為空表示所有左括號都有配對
        return stack.isEmpty();
    }
}