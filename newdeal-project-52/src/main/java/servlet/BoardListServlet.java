package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import Dao.BoardDao;
//서블릿을 만들었으면 톰켓 서버에 알려줘야 한다
//서블릿에 url을 부여한다
//서버 추가할때만 재시작하고, 서브릿에 내용 추가한 후는 
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{
  
  BoardDao boardDao;
  
  @Override
  public void init() throws ServletException {
  //서브릿 객체가 최초 생성될때(생성자 다음에) 바로 호출됨
    //원래는 init(Serveltconfig)가 먼저 호출되고
    //init(Serveltconfig)가 init()를 호출한다
    
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = (ApplicationContext)sc.getAttribute("iocContainer");
    try {
      boardDao = iocContainer.getBean(BoardDao.class);
      
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void doGet(
      HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    //BoardDao 객체를 꺼내기 위해 ioc컨테이너를 꺼낸다
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("게시판 목록");

    try {
      List<Board> list = boardDao.findAll();

      for (Board board : list) {
        out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), 
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
