
package com.finance.p2p.user;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.finance.p2p.api.user.UserDto;
import com.finance.p2p.api.user.UserService;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring-master.xml")
@Transactional
public class TestUserService {
    
    @Resource
    UserService userService;
    
    @Test
    public void testAllUserInfo () {
        
        List<UserDto> users = userService.getAllUserInfo();
        
        System.out.println (users);
        
        assertEquals (1, users.size ());

    }
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
   
}
