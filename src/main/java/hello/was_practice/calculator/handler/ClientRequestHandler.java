package hello.was_practice.calculator.handler;

import hello.was_practice.calculator.Calculator;
import hello.was_practice.calculator.function.PositiveNumber;
import hello.was_practice.calculator.query.QueryStrings;
import hello.was_practice.calculator.request.HttpRequest;
import hello.was_practice.calculator.response.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class ClientRequestHandler implements Runnable{

    //사용자가 요청 할때마다 thread를 생성 한다면 메모리 할당, -> 성능이 매우 떨어지는 형태
    //CPU, contextSwitching 형태가 급격히 증가 -> 최악의 경우 서버 터짐

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);
    private final Socket clientSocket;
    @Override
    public void run() {
        /**
         * step2 - 시용자 요청이 들어올 때마다 Thread를 세로 생성해서, 요청을 처리하도록 한다.
         */
        logger.info("{ClientRequestHandler} new client {} started", Thread.currentThread().getName()); //현재 실행되는 Thread 이름
        try {
            //Thread 별로 input, output Thread 얻는다.
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            //InputStream -> reader로 변경하고 싶었음  (line by line)
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);

            //연결된 BufferedReader를 전달
            HttpRequest httpRequest = new HttpRequest(br);

            //GET 요청 & path가 calculate와 일치하면 queryStrings 가져옴
            if (httpRequest.isGetRequest() && httpRequest.mathPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int rst = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(rst).getBytes();

                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
