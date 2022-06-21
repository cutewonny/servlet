package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }

//    1
//    public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
//        dispatcher.forward(req, res);//서블릿에서 jsp를 호출
//    }


//    2
//    public MyView process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        return new MyView("/WEB-INF/views/new-form.jsp");


//    3
//    public ModelView process(Map<String, String> paramMap) {
//        return new ModelView("new-form");
//    }
}
