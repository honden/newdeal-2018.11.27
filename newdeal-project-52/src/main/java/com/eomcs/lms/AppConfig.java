package com.eomcs.lms;

import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.eomcs.lms.Dao.BoardDao;
import com.eomcs.lms.Dao.LessonDao;
import com.eomcs.lms.Dao.impl.MariaDBBoardDao;
import com.eomcs.lms.Dao.impl.MariaDBLessonDao;

//spring ioc 컨테이너에게 패키지 이름을 알려주면 그 패키지를 뒤져서 
//@Component가 붙은 붙은 클래스에 대해 인스턴스를 자동으로 생성해 준다
@ComponentScan("com.eomcs.lms")

//스프링 ioc 컨테이너에게 프로퍼티 파일을 로딩할 것을 명령한다
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
public class AppConfig {
  //스프링 IOC 컨테이너가 로딩한 ㅡ로퍼티 정보  가져오기
  @Value("${jdbc.driver}")//jdbc값을
  String jdbcDriver;
  @Value("${jdbc.url}")
  String jdbcUrl;
  @Value("${jdbc.username}")
  String jdbcUsername;
  @Value("${jdbc.password}")
  String jdbcPassword;
  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(this.jdbcDriver);
    dataSource.setUrl(this.jdbcUrl);
    dataSource.setUsername(this.jdbcUsername);
    dataSource.setPassword(this.jdbcPassword);
    return dataSource;
  }
  //트랜잭션 객체 생성시 기본 이름으로 설정하라
  //다른이름 사용시 트랜잭션 관련한 다른 개개체 생성시 그 객체가 트랜잭션 관리자를 자동으로 찾지 못한다
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
 
  //스프링 ioc컨테이너에게 이메서드를 호출하여 리턴값을 보관하라는 표시
  //리턴값을 저장할때 사용할 이름을 지정하지 않으면 메서드 이름으로 저장한다 
  //따라서 이름을 동사가 아닌 명사(객체의 이름)의 형태로 짓는다.
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, 
      ApplicationContext iocContainer) throws Exception{
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    //db커넥션 풀 객체 주입
    factoryBean.setDataSource(dataSource);
    //도메인 클래스 (vo)별명 자동생성 하기
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    //sql매퍼 파일 로딩
    //sql mapper file 의 위치정보를 resource 객체에 담아서 넘겨야 한다
    //리소스 객체는 스프링 IOC컨ㅊ테이너를 통해 만들 수 있다.
    //스프링 ioc 컨테이너 객체를 얻는 방법
    //이 메서드의 파라미터에 달라고 요청하라 
    factoryBean.setMapperLocations(iocContainer.getResources(
        "classpath:/com/eomcs/lms/mapper/*Mapper.xml"));
    return factoryBean.getObject();
  }
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
  @Bean
  public BoardDao boardDao(SqlSessionFactory sqlSessionFactory) {
    return new MariaDBBoardDao(sqlSessionFactory);
  }
  @Bean
  public LessonDao lessonDao(SqlSessionFactory sqlSessionFactory) {
    return new MariaDBLessonDao(sqlSessionFactory);
  }
}
