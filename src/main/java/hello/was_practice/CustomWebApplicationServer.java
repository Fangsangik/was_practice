package hello.was_practice;

import hello.was_practice.calculator.handler.ClientRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {

    //ThreadPool 적용하기
    //newFixedThreadPool -> 해당 부분을 ThreadPool을 이용해서 안정적으로 사용
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final int port;

    private static final Logger log = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    //톰켓을 한번 만들어 봄
    //client 요청이 들어왔을때 해당 작업이 mainthread에서 실행
    //if block 걸릴시 다음 실행 요청에 상당한 지연 상황 발생
    //따라서 별도 Thread에서 진행 할 수 있도록 필요
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("CustomWebApplication started {]", port);

            Socket clientSocket;
            log.info("CustomWebApplication waiting for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                log.info("CustomWebApplication client connected");

                //개당 Thread 마다 excute를 타고
                executorService.execute(new ClientRequestHandler(clientSocket));
                //client 마다 별도 스레드 수행
                //new Thread(new ClientRequestHandler(clientSocket)).start();

                /**
                 * step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
//
//                try {
//                    InputStream in = clientSocket.getInputStream();
//                    OutputStream out = clientSocket.getOutputStream();
//                    //InputStream -> reader로 변경하고 싶었음  (line by line)
//                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//                    DataOutputStream dos = new DataOutputStream(out);
//
//
//                    //연결된 BufferedReader를 전달
//                    HttpRequest httpRequest = new HttpRequest(br);
//
//                    //GET 요청 & path가 calculate와 일치하면 queryStrings 가져옴
//                    if (httpRequest.isGetRequest() && httpRequest.mathPath("/calculate")) {
//                       QueryStrings queryStrings = httpRequest.getQueryStrings();
//
//                       int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
//                       String operator = queryStrings.getValue("operator");
//                       int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
//
//                        int rst = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//                        byte[] body = String.valueOf(rst).getBytes();
//
//                        HttpResponse response = new HttpResponse(dos);
//                        response.response200Header("application/json", body.length);
//                        response.responseBody(body);
//                    }
//
//                    //protocal 보여주는 부분 필요 없어짐
//                   DataOutputStream dos = new DataOutputStream(out);
//
//                   String line;
//                   while ((line = br.readLine()) != "") {
//                       System.out.println(line);
//                   }
//                } catch (Exception e){
//                    e.printStackTrace();
            }
        }
    }
}
