package makaza.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import makaza.model.UserDetail;

@Mapper
public interface UserDetailMapper {

	/**
	 * Get all user detail 
	 * @return all user detail
	 */
	List<UserDetail> selectAll();

	/**
	 * Get user detail by userName (userAccount)
	 * @param userName userName
	 * @return user detail
	 */
	UserDetail selectById(String userName);
}
