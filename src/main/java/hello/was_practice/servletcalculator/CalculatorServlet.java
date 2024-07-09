package hello.was_practice.servletcalculator;

import hello.was_practice.calculator.Calculator;
import hello.was_practice.calculator.function.PositiveNumber;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "calculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet implements Servlet {

    private ServletConfig servletConfig;

    //servlet 생성후 초기화 작업을 실행
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("Servlet init");
        this.servletConfig = config; //해당 초기화 발생할때 인스턴스 변수 초기화
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        int param1 = Integer.parseInt(request.getParameter("param1"));
        String operator = request.getParameter("operator");
        int param2 = Integer.parseInt(request.getParameter("param2"));

        int rst = Calculator.calculate(new PositiveNumber(param1), operator, new PositiveNumber(param2));

        PrintWriter writer = response.getWriter();
        writer.println(rst);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //자원을 해지 해주는 작업 필요
    @Override
    public void destroy() {

    }
}
