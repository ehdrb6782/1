package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class App {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			
			String resource = "mybatis-config.xml";
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
		
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("Factory Connection!!");
			
			SqlSession session = sqlSessionFactory.openSession();
			
			int result =  session.selectOne("abcd.test1");
			System.out.println("Result : " + result);
			
			List<User> list = session.selectList("abcd.test2");
			
			System.out.println(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
	}

}
