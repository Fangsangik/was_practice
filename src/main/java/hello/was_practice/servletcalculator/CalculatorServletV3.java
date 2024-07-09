package hello.was_practice.servletcalculator;

import hello.was_practice.calculator.Calculator;
import hello.was_practice.calculator.function.PositiveNumber;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "calculatorServlet", urlPatterns = "/calculate")
public class CalculatorServletV3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param1 = Integer.parseInt(request.getParameter("param1"));
        String operator = request.getParameter("operator");
        int param2 = Integer.parseInt(request.getParameter("param2"));

        int rst = Calculator.calculate(new PositiveNumber(param1), operator, new PositiveNumber(param2));
        System.out.println("rst = " + rst);
    }
    //HttpServlet ->  get 요청일때 Post, delete 요청마다 메소드를 구현 해주면 된다.
}
