package hello.was_practice.request;

import hello.was_practice.query.QueryStrings;
import hello.was_practice.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine()); //protocol에 첫 라인이 requestLine
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }

    public boolean isGetRequest() {
        //http 요청은 모름
        //requestLine -> get이니? 다시 물어봄
        return requestLine.isGetRequest();
    }

    public boolean mathPath(String path) {
        return requestLine.mathPath(path);
    }
}
