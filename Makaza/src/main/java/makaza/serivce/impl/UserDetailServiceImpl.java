package makaza.serivce.impl;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import makaza.common.CodeDef;
import makaza.mapper.UserAccountMapper;
import makaza.mapper.UserDetailMapper;
import makaza.mapper.UserRoleMapper;
import makaza.model.UserAccount;
import makaza.model.UserDetail;
import makaza.model.UserRole;
import makaza.serivce.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailMapper userDetailMapper;

	@Autowired
	private UserAccountMapper userAccountMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public List<UserDetail> findAllUsers() {
		return this.userDetailMapper.selectAll();
	}

	@Override
	public UserDetail findById(String userName) {
		return this.userDetailMapper.selectById(userName);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void save(UserDetail userDetail) {

		UserAccount userAccount = new UserAccount();
		BeanUtils.copyProperties(userDetail, userAccount);
		String encode = this.passwordEncoder.encode(userAccount.getPassword());
		userAccount.setPassword(encode);
		userAccount.setDelFlg(CodeDef.NON_DELETE.getCode());
		this.userAccountMapper.insertSelective(userAccount);

		UserRole userRole = new UserRole();
		BeanUtils.copyProperties(userDetail, userRole);
		this.userRoleMapper.insertSelective(userRole);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void update(UserDetail userDetail) {

		UserAccount userAccount = new UserAccount();
		BeanUtils.copyProperties(userDetail, userAccount);
		if (!Strings.isEmpty(userAccount.getPassword())) {
			String encode = this.passwordEncoder.encode(userAccount.getPassword());
			userAccount.setPassword(encode);
		} else {
			userAccount.setPassword(null);
		}

		this.userAccountMapper.update(userAccount);

		UserRole userRole = new UserRole();
		BeanUtils.copyProperties(userDetail, userRole);
		this.userRoleMapper.insertOrUpdate(userRole);
	}

	@Override
	public void delete(String userName) {
		this.userAccountMapper.deleteLogic(userName, CodeDef.DELETE.getCode());
	}
}
