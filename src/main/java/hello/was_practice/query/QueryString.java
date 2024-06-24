package hello.was_practice.query;

import lombok.Getter;

@Getter
public class QueryString {

    private final String key;
    private final String val;

    public QueryString(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public boolean exsits(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.val;
    }
}
