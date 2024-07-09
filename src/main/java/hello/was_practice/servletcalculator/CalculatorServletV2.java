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
public class CalculatorServletV2 extends GenericServlet {
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

    //GenericServlet -> service 메소드 외 나머지는 추상 메서드 필요 없다면 굳이 설정 할 필요 없음
}
