package hello.was_practice.caculator.query;

import hello.was_practice.calculator.query.QueryStrings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryStringsTest {

    @Test
    void create() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55"); //내부적으로 여러개를 갖는 queryString
        Assertions.assertThat(queryStrings).isNotNull();
    }
}