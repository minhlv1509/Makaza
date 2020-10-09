package makaza.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import makaza.model.UserDetail;

@Mapper
public interface UserDetailMapper {

	List<UserDetail> selectAll();

	UserDetail selectById(String userName);
}
