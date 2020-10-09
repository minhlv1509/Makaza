package makaza.model;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -2515966713407070650L;

	/** userName */
	private String userName;

	/** status */
	private String status;

	/** password */
	private String password;

	/** passwordReminderToken */
	private String passwordReminderToken;

	/** passwordReminderExpire */
	private Date passwordReminderExpire;

	/** emailConfirmationToken */
	private String emailConfirmationToken;

	/** firstName */
	private String firstName;

	/** lastName */
	private String lastName;

	/** email */
	private String email;

	/** address */
	private String address;

	/** phoneNumber */
	private String phoneNumber;

	/** roleId */
	private int roleId;
	
	/** roleName */
	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordReminderToken() {
		return passwordReminderToken;
	}

	public void setPasswordReminderToken(String passwordReminderToken) {
		this.passwordReminderToken = passwordReminderToken;
	}

	public Date getPasswordReminderExpire() {
		return passwordReminderExpire;
	}

	public void setPasswordReminderExpire(Date passwordReminderExpire) {
		this.passwordReminderExpire = passwordReminderExpire;
	}

	public String getEmailConfirmationToken() {
		return emailConfirmationToken;
	}

	public void setEmailConfirmationToken(String emailConfirmationToken) {
		this.emailConfirmationToken = emailConfirmationToken;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
