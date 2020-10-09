package makaza.service.impl;

import java.util.Date;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import makaza.model.UserDetail;
import makaza.serivce.UserDetailService;

@RunWith(SpringRunner.class)
@Transactional 
@SpringBootTest
public class UserDetailServiceImplTest {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public static final String USER_NAME_EXISTED = "lvm";
	
	public static final String USER_NAME_NOT_EXISTED = "USER_NAME_NOT_EXISTED";
	
	public static final String USER_NAME = "userName";
	public static final String STATUS = "2";
	public static final String PASSWORD = "password";
	public static final String PASSWORD_REMINDER_TOKEN = "passwordReminderToken";
	public static final Date PASSWORD_REMINDER_EXPIRE = new Date();
	public static final String EMAIL_CONFIRMATION_TOKEN = "emailConfirmationToken";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String PHONE_NUMBER = "1234567890";
	public static final int ROLE_ID = 2;

	/** test findAllUsers */
	@Test
    public void testFindAllUsers() {
        Assert.assertEquals(2, this.userDetailService.findAllUsers().size());
    }
	
	/** test findById */
	@Test
    public void testFindById() {
		UserDetail user = this.userDetailService.findById(USER_NAME_EXISTED);
        Assert.assertEquals(USER_NAME_EXISTED, user.getUserName());
    }
	
	/** test save */
	@Test
    public void testSave() {
		try {
			UserDetail user = new UserDetail();

			user.setUserName(USER_NAME_NOT_EXISTED);
			user.setStatus(STATUS);
			user.setPassword(PASSWORD);
			user.setPasswordReminderToken(PASSWORD_REMINDER_TOKEN);
			user.setPasswordReminderExpire(PASSWORD_REMINDER_EXPIRE);
			user.setEmailConfirmationToken(EMAIL_CONFIRMATION_TOKEN);
			user.setFirstName(FIRST_NAME);
			user.setLastName(LAST_NAME);
			user.setEmail(EMAIL);
			user.setAddress(ADDRESS);
			user.setPhoneNumber(PHONE_NUMBER);
			user.setRoleId(ROLE_ID);
			
			this.userDetailService.save(user);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
	
	/** test update password != null */
	@Test
    public void testUpdate1() {
		try {
			UserDetail expected = new UserDetail();

			expected.setUserName(USER_NAME_EXISTED);
			expected.setStatus(STATUS);
			expected.setPassword(PASSWORD);
			expected.setPasswordReminderToken(PASSWORD_REMINDER_TOKEN);
			expected.setPasswordReminderExpire(PASSWORD_REMINDER_EXPIRE);
			expected.setEmailConfirmationToken(EMAIL_CONFIRMATION_TOKEN);
			expected.setFirstName(FIRST_NAME);
			expected.setLastName(LAST_NAME);
			expected.setEmail(EMAIL);
			expected.setAddress(ADDRESS);
			expected.setPhoneNumber(PHONE_NUMBER);
			expected.setRoleId(ROLE_ID);
			
			this.userDetailService.update(expected);
			
			UserDetail actual = this.userDetailService.findById(USER_NAME_EXISTED);
			Assert.assertEquals(expected.getUserName(), actual.getUserName());
			Assert.assertEquals(expected.getStatus(), actual.getStatus());
			Assert.assertTrue(this.passwordEncoder.matches(expected.getPassword(), actual.getPassword()));
			Assert.assertEquals(expected.getPasswordReminderToken(), actual.getPasswordReminderToken());
			Assert.assertEquals(expected.getEmailConfirmationToken(), actual.getEmailConfirmationToken());
			Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
			Assert.assertEquals(expected.getLastName(), actual.getLastName());
			Assert.assertEquals(expected.getEmail(), actual.getEmail());
			Assert.assertEquals(expected.getAddress(), actual.getAddress());
			Assert.assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
			Assert.assertEquals(expected.getRoleId(), actual.getRoleId());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
	
	/** test update password = null */
	@Test
    public void testUpdate2() {
		try {
			UserDetail expected = new UserDetail();

			expected.setUserName(USER_NAME_EXISTED);
			expected.setStatus(STATUS);
			expected.setPassword(null);
			expected.setPasswordReminderToken(PASSWORD_REMINDER_TOKEN);
			expected.setPasswordReminderExpire(PASSWORD_REMINDER_EXPIRE);
			expected.setEmailConfirmationToken(EMAIL_CONFIRMATION_TOKEN);
			expected.setFirstName(FIRST_NAME);
			expected.setLastName(LAST_NAME);
			expected.setEmail(EMAIL);
			expected.setAddress(ADDRESS);
			expected.setPhoneNumber(PHONE_NUMBER);
			expected.setRoleId(ROLE_ID);
			
			this.userDetailService.update(expected);
			
			UserDetail actual = this.userDetailService.findById(USER_NAME_EXISTED);
			Assert.assertEquals(expected.getUserName(), actual.getUserName());
			Assert.assertEquals(expected.getStatus(), actual.getStatus());
			Assert.assertTrue(!Objects.equals(expected.getPassword(), actual.getPassword()));
			Assert.assertEquals(expected.getPasswordReminderToken(), actual.getPasswordReminderToken());
			Assert.assertEquals(expected.getEmailConfirmationToken(), actual.getEmailConfirmationToken());
			Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
			Assert.assertEquals(expected.getLastName(), actual.getLastName());
			Assert.assertEquals(expected.getEmail(), actual.getEmail());
			Assert.assertEquals(expected.getAddress(), actual.getAddress());
			Assert.assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
			Assert.assertEquals(expected.getRoleId(), actual.getRoleId());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }

	/** test delete */
	@Test
    public void testDelete() {
		try {
			this.userDetailService.delete(USER_NAME_EXISTED);

			UserDetail actual = this.userDetailService.findById(USER_NAME_EXISTED);
			
			Assert.assertTrue(!Objects.nonNull(actual));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
}
