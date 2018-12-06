package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import Dao.LessonDao;
//서블릿을 만들었으면 톰켓 서버에 알려줘야 한다
//서블릿에 url을 부여한다
//서버 추가할때만 재시작하고, 서브릿에 내용 추가한 후는 
@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  LessonDao lessonDao;
  
  @Override
  public void init() throws ServletException {
    // 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 
    // 바로 호출된다.
    // => 원래는 init(ServletConfig)가 먼저 호출되고,
    //    init(ServletConfig)가 이 init()를 호출한다.
    // BoardDao 객체를 꺼내기 위해 먼저 IoC 컨테이너를 꺼낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    
    try {
      lessonDao = iocContainer.getBean(LessonDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      List<Lesson> list = lessonDao.findAll();
      
      // 게시물 목록을 JSP가 사용할 수 있도록 보관소 저장한다.
      request.setAttribute("list", list);
      
      // JSP로 실행을 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher(
          "/lesson/list.jsp");
      
      // 출력 콘텐트의 타입을 include 하는 쪽에서 지정해야 한다.
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
} 
