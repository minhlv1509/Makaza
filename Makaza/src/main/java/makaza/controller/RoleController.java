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
import makaza.model.Roles;
import makaza.serivce.RoleService;

/**
 * RoleController
 * 
 * @author Minh
 */
@RestController
public class RoleController extends BaseController {

	/** Role management */
	@Autowired
	private RoleService roleService;

	/**
	 * Get all roles
	 * 
	 * @return List all roless
	 */
	@GetMapping("/api/roles")
	public ResponseEntity<List<Roles>> findAllUsers() { // @PathVariable("userName") String userName
		List<Roles> roles = this.roleService.findAllRoles();
		return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
	}

	/**
	 * Get user by userName
	 * 
	 * @param userName userName
	 * @return user
	 */
	@GetMapping("/api/role/{id}")
	public ResponseEntity<Roles> getCricketer(@PathVariable("id") int id) {
		Roles role = this.roleService.findById(id);
		if (Objects.nonNull(role)) {
			return new ResponseEntity<Roles>(role, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Add new user
	 * 
	 * @param userDetail user and role
	 * @return ReturnEnity
	 */
	@PostMapping("/api/role")
	@CacheEvict(value = "Roles", allEntries = true)
	public ResponseEntity<ReturnEnity> addUser(@RequestBody Roles role) {
		this.roleService.save(role);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_ROLE_ADDED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}

	/**
	 * Update user's information
	 * 
	 * @param userDetail user and role
	 * @return ReturnEnity
	 */
	@PutMapping("/api/role")
	@CacheEvict(value = "Roles", allEntries = true)
	public ResponseEntity<ReturnEnity> updateUser(@RequestBody Roles role) {
		this.roleService.update(role);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_ROLE_UPDATED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}

	/**
	 * Delete user
	 * 
	 * @param userName userName
	 * @return ReturnEnity
	 */
	@DeleteMapping("/api/role/{id}")
	@CacheEvict(value = "UserDetail", allEntries = true)
	public ResponseEntity<ReturnEnity> deleteUser(@PathVariable("id") int id) {
		this.roleService.delete(id);

		ReturnEnity value = this.setReturnValue(CodeDef.SUCCESS.getCode(), Constants.MSG_ROLE_REMOVED);
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}
}
