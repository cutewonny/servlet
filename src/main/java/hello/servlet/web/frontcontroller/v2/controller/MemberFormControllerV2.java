package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
//ctrl + Alt + 화살표
    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//    hello/servlet/web/frontcontroller/v1/controller/MemberFormControllerV1.java
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
//        dispatcher.forward(req, res);//서블릿에서 jsp를 호출

        //ctrl + Alt + N
//        MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
//        return myView;
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
