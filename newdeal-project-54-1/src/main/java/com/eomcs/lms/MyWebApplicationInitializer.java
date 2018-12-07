package com.eomcs.lms;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//WebApplicationInitializer 구현체는 웹어플리케이션이 시작될때 실행된다.
public class MyWebApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletCxt) {
//       이 메서드가 호출 될 때 할 일
//    1.프론트 컨트롤러가 사용할 스프링 IoC컨테이너를 준비한다
      AnnotationConfigWebApplicationContext iocContainer = new AnnotationConfigWebApplicationContext();
      iocContainer.register(AppConfig.class);
      iocContainer.refresh();
      
      //객체 출력 문구
      System.out.println(iocContainer.getBeanDefinitionCount());
      String[] names = iocContainer.getBeanDefinitionNames();
      for (String name : names) {
        System.out.printf("%s ===> %s\n", name, 
            iocContainer.getBean(name).getClass().getName());
      }
//  2.ㅍ프론트 컨트롤러(dispatcherServlet)를 서블릿 컨테이너에 등록한다
//      프론트 컨트롤러를 생성 시 이 객체가 사용 할 spring Ioc를 알려준다
      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      
//      서블릿 컨테이너에 위에서 만든 프론트 컨트롤러 서블릿을 등록한다
      ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
      
//      등록한 서블릿에 정보를 설정한다.
      registration.setLoadOnStartup(1);
//      웹 애플리케이션이 시작될 때 프론트 컨트롤러를 생성하라고 지정한다
      registration.addMapping("/app/*");
//      프론트 컨트롤러의 URL을 지정한다.
  }
}