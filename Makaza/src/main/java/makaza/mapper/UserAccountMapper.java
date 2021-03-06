package makaza.mapper;

import org.apache.ibatis.annotations.Mapper;

import makaza.model.UserAccount;

@Mapper
public interface UserAccountMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table user_account
	 * 
	 * @mbg.generated
	 */
	int insert(UserAccount record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table user_account
	 * 
	 * @mbg.generated
	 */
	int insertSelective(UserAccount record);

	/**
	 * Update user
	 * 
	 * @param record user
	 * @return quantity has been updated
	 */
	int update(UserAccount record);

	/**
	 * Delete Logic
	 * 
	 * @param record user
	 * @return quantity has been deleted
	 */
	int deleteLogic(String userName, String delFlg);
}