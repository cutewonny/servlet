package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerSevletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerSevletV1 extends HttpServlet {
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //생성자
    public FrontControllerSevletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("프론트 컨트롤러 시작! FrontControllerSevletV1.service");
        String requestURI = req.getRequestURI();

        //다형성
        // ControllerV1 controller = new MemberFormControllerV1();
        ControllerV1 controller = controllerMap.get(requestURI);
        System.out.println("controllerMap = " + controllerMap);
        System.out.println("requestURI = " + requestURI);
        System.out.println("controller = " + controller);

        if(this.controllerMap == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(req, res);
    }
}
