package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import Dao.BoardDao;
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;
  
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
  }
  
  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findByNo(no);
      request.setAttribute("board", board);
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/detail.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
    
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}

/*@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  BoardDao boardDao;
  
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext)this.getServletContext()
        .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
  }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
      System.out.print("번호? ");
      
      Board board = boardDao.findByNo(no);
      board.getNo = Integer.parseInt(request.getParameter("no"));
      

//      request.setAttribute("detail", detail);
      response.setContentType("text/html;charset=UTF-8");
      //jsp에 위임한다
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/list.jsp");
      
      //출력콘텐트의 타입을 include하는 쪽에서 지정해야 한다
      rd.include(request, response);
      
    }catch (Exception e){
      e.printStackTrace();
      throw new ServletException(e); 
    }
  }
}
*/
