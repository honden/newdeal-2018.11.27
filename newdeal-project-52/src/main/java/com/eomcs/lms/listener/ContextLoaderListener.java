package com.eomcs.lms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
  //웹 어플리케이션이 시작 및 종료때 호출되는 메서드를 정의
  AnnotationConfigApplicationContext iocContainer;
  @Override//웹 어플리케이션 시작됨
  public void contextInitialized(ServletContextEvent sce) {
    // TODO Auto-generated method stub
    System.out.println("웹 어플리케이션 시작됨");
    //appconfig클래스가 메모리에 로딩되어 있지 않다면 지금 즉시 로딩 후 클래스 정보를 리턴하라
    //스프링 아이오시 컨테이너 준비하기
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);

    System.out.println(iocContainer.getBeanDefinitionCount());
    String[] names = iocContainer.getBeanDefinitionNames();
    for(String name : names) {
      System.out.printf("%s ===> %s\n",name,
          iocContainer.getBean(name).getClass().getName());
    }
    ServletContext sc = sce.getServletContext();
    sc.setAttribute("iocContainer", iocContainer);
    ServletContextListener.super.contextInitialized(sce);
  }

  @Override//웹 어플리케이션 종료됨
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub\
    System.out.println("웹 어플리케이션 종료됨");
    //프로그램 닫힐때 ioc자원  해제
    this.iocContainer.close();
    ServletContextListener.super.contextDestroyed(sce);
  }
}
