import java.util.*;

public class CardMatchingGame {
    
    /**
     * 處理單一測資的所有指令
     * @param commands 指令陣列
     * @return 此測資的所有輸出，每行用 \n 分隔
     */
    public static String process(String[] commands) {
        // 使用 HashMap 記錄每種數字的卡片數量
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        List<String> outputs = new ArrayList<>();
        
        for (String cmd : commands) {
            if (cmd.startsWith("add ")) {
                int n = Integer.parseInt(cmd.substring(4).trim());
                
                // 增加該數字的卡片數量
                cardCount.put(n, cardCount.getOrDefault(n, 0) + 1);
                
            } else if (cmd.startsWith("remove ")) {
                int n = Integer.parseInt(cmd.substring(7).trim());
                
                // 檢查卡片是否存在
                if (!cardCount.containsKey(n) || cardCount.get(n) == 0) {
                    outputs.add("Card not found");
                } else {
                    // 減少該數字的卡片數量
                    int count = cardCount.get(n);
                    if (count == 1) {
                        cardCount.remove(n);
                    } else {
                        cardCount.put(n, count - 1);
                    }
                }
                
            } else if (cmd.startsWith("check ")) {
                int n = Integer.parseInt(cmd.substring(6).trim());
                
                // 檢查是否有至少一張卡片
                boolean exists = cardCount.containsKey(n) && cardCount.get(n) > 0;
                outputs.add(exists ? "true" : "false");
                
            } else if (cmd.equals("count")) {
                // 計算卡片總張數
                int total = 0;
                for (int count : cardCount.values()) {
                    total += count;
                }
                outputs.add(String.valueOf(total));
                
            } else if (cmd.equals("pair")) {
                // 計算可以配成的對數
                int pairs = 0;
                for (int count : cardCount.values()) {
                    pairs += count / 2;
                }
                outputs.add(String.valueOf(pairs));
            }
        }
        
        return String.join("\n", outputs);
    }
}