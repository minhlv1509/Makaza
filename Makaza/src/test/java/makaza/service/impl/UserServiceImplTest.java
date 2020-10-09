package makaza.service.impl;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional 
@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	private UserDetailsService service;
	
public static final String USER_NAME_EXISTED = "lvm";
	
	public static final String USER_NAME_NOT_EXISTED = "USER_NAME_NOT_EXISTED";
	
	/** test loadUserByUsername */
	@Test
    public void testLoadUserByUsername1() {
		
		UserDetails user = this.service.loadUserByUsername(USER_NAME_EXISTED);
		
        Assert.assertTrue(Objects.nonNull(user));
    }
	
	/** test loadUserByUsername */
	@Test
    public void testLoadUserByUsername21() {
		try {
			this.service.loadUserByUsername(USER_NAME_NOT_EXISTED);
			Assert.assertTrue(false);
		} catch (UsernameNotFoundException e) {
			Assert.assertTrue(true);
		}
    }
}
