package baseball.view.message;

import java.util.HashMap;
import java.util.Map;

public class MessageParam {

    private final Map<String, String> map = new HashMap<>();

    public void add(String key, Object value) {
        map.put(key, value.toString());
    }

    public String get(String key) {
        return map.get(key);
    }

    public static MessageParam empty() {
        return new MessageParam();
    }
}
