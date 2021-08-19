package ml.zhannicholas.concurrency.thread.safety;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * HashMap 不是线程安全的
 */
public class UnsafeHashMap {
    public static void main(String[] args) {
        final Map<Integer, String> map = new HashMap<>();
        final Integer maximumKey = Integer.MAX_VALUE;
        map.put(maximumKey, "V");

        new Thread(() -> IntStream.range(0, maximumKey).forEach(k -> map.put(k, "value"))).start();

        try {
            while (true) {
                // 扩容复制回填时可能取到 null
                if (null == map.get(maximumKey)) {
                    throw new RuntimeException("HashMap is not thread-safe.");
                }
            }
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
