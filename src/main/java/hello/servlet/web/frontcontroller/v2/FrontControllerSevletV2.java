package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerSevletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerSevletV2 extends HttpServlet {
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    //기본 생성자
    public FrontControllerSevletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("프론트 컨트롤러 시작! FrontControllerSevletV2.service");
        String requestURI = req.getRequestURI();

        //다형성
        // ControllerV1 controller = new MemberFormControllerV1();
        ControllerV2 controller = controllerMap.get(requestURI);

        if(this.controllerMap == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
//        수정됨 ctrl + Alt + B, 구현체 ctrl+alt+B
        MyView view = controller.process(req, res);//return new MyView("/WEB-INF/views/new-form.jsp");
        view.render(req, res);
    }
}
