import java.util.*;

public class CourseSelectionSystem {
    
    /**
     * 處理單一測資的所有指令
     * @param commands 指令陣列
     * @return 此測資的所有輸出
     */
    public static String process(String[] commands) {
        List<String> courses = new ArrayList<>();
        List<String> outputs = new ArrayList<>();
        
        for (String cmd : commands) {
            if (cmd.startsWith("add ")) {
                String course = cmd.substring(4).trim();
                
                // 檢查是否存在（不區分大小寫）
                boolean exists = false;
                for (String c : courses) {
                    if (c.equalsIgnoreCase(course)) {
                        exists = true;
                        break;
                    }
                }
                
                if (exists) {
                    outputs.add("Course already exists");
                } else {
                    courses.add(course);
                }
                
            } else if (cmd.startsWith("remove ")) {
                String course = cmd.substring(7).trim();
                
                // 尋找並移除（不區分大小寫）
                int indexToRemove = -1;
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).equalsIgnoreCase(course)) {
                        indexToRemove = i;
                        break;
                    }
                }
                
                if (indexToRemove != -1) {
                    courses.remove(indexToRemove);
                } else {
                    outputs.add("Course not found");
                }
                
            } else if (cmd.equals("list")) {
                if (courses.isEmpty()) {
                    outputs.add("No courses");
                } else {
                    outputs.add(String.join(", ", courses));
                }
            }
        }
        
        return String.join("\n", outputs);
    }
}