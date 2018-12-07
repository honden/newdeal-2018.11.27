package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.Dao.BoardDao;
import com.eomcs.lms.Dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  BoardDao boardDao;
  LessonDao lessonDao;
  
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }
  
  @Override
  protected void doGet(
    HttpServletRequest request, 
    HttpServletResponse response)
    throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member)session.getAttribute("loginUser");
    
    List<Map<String,Object>>lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());

    //이건 톰켓(서버)에서 웹브라우져에 요청하기때문에 폴더 전체를 다 말해줘야 한다
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/form.jsp");
    rd.forward(request, response);
  }
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      board.setWriterNo(loginUser.getNo());

      board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));
      
      boardDao.insert(board);
      //브라우저에서 상대 경로이기때문에 /board/list로 안해도 된다 /board/add에서 넘어가기때문에 /board/....으로 여기기 때문
      response.sendRedirect("list");
    }catch (Exception e){
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}
