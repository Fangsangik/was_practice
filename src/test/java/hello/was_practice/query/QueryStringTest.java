package hello.was_practice.query;

import hello.was_practice.query.QueryString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueryStringTest {
    /**
     * step1 : operand1=11
     * List<QueryString>
     */
    @Test
    void create() {
        QueryString queryString = new QueryString("operand1", "11");
        Assertions.assertThat(queryString).isNotNull();
    }
}
