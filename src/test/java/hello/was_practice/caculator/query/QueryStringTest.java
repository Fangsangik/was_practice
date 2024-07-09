package hello.was_practice.caculator.query;

import hello.was_practice.calculator.query.QueryString;
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
