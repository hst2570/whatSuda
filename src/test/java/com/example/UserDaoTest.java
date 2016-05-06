package com.example;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dao.UserDao;
import com.domain.User;

public class UserDaoTest {
	
	private UserDao userDao;
//	private UserRepository userRepository;
//	
//	@Autowired
//    public void setcommentRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
	
    @Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }
	
    @Test
    public void get() throws SQLException, ClassNotFoundException {
    	String id = "1";
        User user = userDao.getUserInfo(id);
        System.out.println("---------------------"+user.getId());
        assertEquals(id, user.getId());
    }

//    @Test
//    public void add() throws SQLException, ClassNotFoundException {
//    	String id = "2";
//        
//        User resultSet = userDao.getUserInfo(id);
//
//        assertEquals(id, resultSet.getId());
//    }
//
//    @Test
//    public void delete() throws SQLException, ClassNotFoundException {
//    	String id = "3";
//
//        User resultUser = userDao.getUserInfo(id);
//
//        assertEquals(resultUser, null);
//    }
//
//    @Test
//    public void update() throws SQLException, ClassNotFoundException {
//        User user = new User();
//
//        String id = "3";
//        
//        user.setId(id);
//
//        userDao.update(user);
//
//        User resultUser = userDao.getUserInfo(id);
//
//        assertEquals(id, resultUser.getId());
//    }
}
