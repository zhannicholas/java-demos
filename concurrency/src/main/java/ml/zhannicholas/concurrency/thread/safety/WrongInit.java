package ml.zhannicholas.concurrency.thread.safety;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象被错误的初始化，导致逃逸问题
 */
public class WrongInit {
    private Map<String, String> colorMap;

    public WrongInit() {
        new Thread(() -> {
            colorMap = new HashMap<>();
            colorMap.put("RED", "红");
            colorMap.put("ORANGE", "橙");
            colorMap.put("YELLOW", "黄");
            // ...
        }).start();
    }

    public Map<String, String> getColorMap() {
        return colorMap;
    }

    public static void main(String[] args) {
        WrongInit wrongInit = new WrongInit();
        System.out.println(wrongInit.getColorMap().get("RED"));
    }
}
