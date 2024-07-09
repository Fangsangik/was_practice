package hello.was_practice;

import hello.was_practice.calculator.query.QueryStrings;
import lombok.Getter;

import java.util.Objects;

/** "GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1"
 * httpMethod
 * path
 * queryString
 * protocol
 */
public class RequestLine {

    private final String method; //GET
    private final String urlPath; // /calculate

    @Getter
    private QueryStrings queryStrings; // operand1=11&operator=*&operand2=55
    //queryString이 key & value 형태로 나눠저 있기를 희망

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0]; //GET

        String[] urlPathTokens = tokens[1].split("\\?"); //? 물음표 기준으로 split
        this.urlPath = urlPathTokens[0]; //calculate

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]); //operand1=11&operator=*&operand2=55
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean mathPath(String requestPath) {
        return urlPath.equals(requestPath);
    }
}
