package com.eomcs.lms;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import Dao.BoardDao;
import Dao.impl.MariaDBBoardDao;

//spring ioc 컨테이너에게 패키지 이름을 알려주면 그 패키지를 뒤져서 
//@Component가 붙은 붙은 클래스에 대해 인스턴스를 자동으로 생성해 준다
@ComponentScan("com.eomcs.lms")
public class AppConfig {
  //스프링 ioc컨테이너에게 이메서드를 호출하여 리턴값을 보관하라는 표시
  //리턴값을 저장할때 사용할 이름을 지정하지 않으면 메서드 이름으로 저장한다 
  //따라서 이름을 동사가 아닌 명사(객체의 이름)의 형태로 짓는다.
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception{
    String resource = "com/eomcs/lms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(inputStream);
  }
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
//  @Bean
  public BoardDao boardDao(SqlSessionFactory sqlSessionFactory) {
    return new MariaDBBoardDao(sqlSessionFactory);
  }
}
