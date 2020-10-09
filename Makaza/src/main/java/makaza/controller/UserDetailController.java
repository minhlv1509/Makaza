package makaza.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import makaza.common.CodeDef;
import makaza.common.Constants;
import makaza.model.ReturnEnity;
import makaza.model.UserDetail;
import makaza.serivce.UserDetailService;

/**
 * UserDetailController
 * 
 * @author Minh
 */
@RestController
public class UserDetailController extends BaseController {

	/** User management */
	@Autowired
	private UserDetailService userDetailService;

	/**
	 * Get all users
	 * 
	 * @return List all users
	 */
	@GetMapping("/api/users")
	public ResponseEntity<List<UserDetail>> findAllUsers() { // @PathVariable("userName") String userName
		List<UserDetail> users = this.userDetailService.findAllUsers();
		return new ResponseEntity<List<UserDetail>>(users, HttpStatus.OK);
	}

	/**
	 * Get user by userName
	 * 
	 * @param userName userName
	 * @return user
	 */
	@GetMapping("/api/user/{userName}")
	public ResponseEntity<UserDetail> getCricketer(@PathVariable("userName") String userName) {
		UserDetail user = this.userDetailService.findById(userName);
		if (Objects.nonNull(user)) {
			return new ResponseEntity<UserDetail>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Add new user
	 * 
	 * @param userDetail user and role
	 * @return ReturnEnity
	 */
	@PostMapping("/api/user")
	@CacheEvict(value = "UserDetail", allEntries = true)
	public ResponseEntity<ReturnEnity> addUser(@RequestBody UserDetail userDetail) {
		this.userDetailService.save(userDetail);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_USER_ADDED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}

	/**
	 * Update user's information
	 * 
	 * @param userDetail user and role
	 * @return ReturnEnity
	 */
	@PutMapping("/api/user")
	@CacheEvict(value = "UserDetail", allEntries = true)
	public ResponseEntity<ReturnEnity> updateUser(@RequestBody UserDetail userDetail) {
		this.userDetailService.update(userDetail);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_USER_UPDATED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}

	/**
	 * Delete user
	 * 
	 * @param userName userName
	 * @return ReturnEnity
	 */
	@DeleteMapping("/api/user/{userName}")
	@CacheEvict(value = "UserDetail", allEntries = true)
	public ResponseEntity<ReturnEnity> deleteUser(@PathVariable("userName") String userName) {
		this.userDetailService.delete(userName);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_USER_REMOVED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}
}
