package makaza.serivce;

import java.util.List;

import makaza.model.UserDetail;

public interface UserDetailService {

	List<UserDetail> findAllUsers();

	UserDetail findById(String userName);

	void save(UserDetail userDetail);

	void update(UserDetail userDetail);

	void delete(String userName);
}
