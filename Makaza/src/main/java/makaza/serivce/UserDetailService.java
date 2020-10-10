package makaza.serivce;

import java.util.List;

import makaza.model.UserDetail;

/**
 * UserDetailService
 * @author Minh
 */
public interface UserDetailService {

	/**
	 * Get all users
	 * @return list users
	 */
	List<UserDetail> findAllUsers();

	/**
	 * Get user by userName
	 * @param userName userName
	 * @return userDetail
	 */
	UserDetail findById(String userName);

	/**
	 * Add user to DB
	 * @param userDetail user
	 */
	void save(UserDetail userDetail);

	/**
	 * Update user
	 * @param userDetail user
	 */
	void update(UserDetail userDetail);

	/**
	 * delete login user (DEL_FLG=0)
	 * @param userName userName
	 */
	void delete(String userName);
}
