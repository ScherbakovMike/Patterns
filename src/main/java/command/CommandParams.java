package command;

import java.util.HashMap;
import java.util.Map;

public class CommandParams {
    private final Map<String, Object> params = new HashMap<>();

    public CommandParams(Map<String, Object> params) {
        this.params.putAll(params);
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public void setParam(String key, Object value) {
        params.put(key, value);
    }
}
