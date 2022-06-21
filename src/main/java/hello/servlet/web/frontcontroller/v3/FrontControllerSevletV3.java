package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerSevletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerSevletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    //기본 생성자
    public FrontControllerSevletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("프론트 컨트롤러 시작! FrontControllerSevletV3.service");
        String requestURI = req.getRequestURI();

        //다형성
        // ControllerV1 controller = new MemberFormControllerV1();
        ControllerV3 controller = controllerMap.get(requestURI);

        if (this.controllerMap == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
//        수정됨 ctrl + Alt + B, 구현체 ctrl+alt+B
//        MyView view = controller.process(req, res);//return new MyView("/WEB-INF/views/new-form.jsp");
//        view.render(req, res);

        //Ctrl + Alt + M -> 함수만들어줌
        Map<String, String> paramMap = createParamMap(req);

        ModelView mv = controller.process(paramMap);

        //글씨 앞 뒤
        String viewName = mv.getViewName();//논리이름
        MyView myView = viewResolver(viewName);

        myView.render(mv.getModel(), req, res);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");//물리 이름
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
