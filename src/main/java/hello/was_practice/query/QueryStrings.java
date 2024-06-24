package hello.was_practice.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens).forEach(queryString -> {
            String[] value = queryString.split("=");
            if (value.length != 2) {
                throw new IllegalArgumentException("잘못된 QueryString 포멧을 가진 문자열 입니다");
            }
            queryStrings.add(new QueryString(value[0], value[1]));
        });
    }

    public String getValue(String key) {
       return this.queryStrings.stream().filter(queryString -> queryString.exsits(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
