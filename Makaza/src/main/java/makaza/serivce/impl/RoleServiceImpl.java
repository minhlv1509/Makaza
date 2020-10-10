package makaza.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import makaza.common.CodeDef;
import makaza.mapper.RolesMapper;
import makaza.model.Roles;
import makaza.serivce.RoleService;

/**
 * RoleServiceImpl
 * 
 * @author Minh
 */
@Service
public class RoleServiceImpl implements RoleService {

	/** RolesMapper */
	@Autowired
	private RolesMapper rolesMapper;

	/*
	 * (non-Javadoc)
	 * @see makaza.serivce.RoleService#findAllRoles()
	 */
	@Override
	public List<Roles> findAllRoles() {
		return this.rolesMapper.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * @see makaza.serivce.RoleService#findById(int)
	 */
	@Override
	public Roles findById(int id) {
		return this.rolesMapper.selectById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see makaza.serivce.RoleService#save(makaza.model.Roles)
	 */
	@Override
	public void save(Roles role) {
		role.setDelFlg(CodeDef.NON_DELETE.getCode());
		this.rolesMapper.insertSelective(role);
	}

	/*
	 * (non-Javadoc)
	 * @see makaza.serivce.RoleService#update(makaza.model.Roles)
	 */
	@Override
	public void update(Roles role) {
		this.rolesMapper.update(role);
	}

	/*
	 * (non-Javadoc)
	 * @see makaza.serivce.RoleService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.rolesMapper.deleteLogic(id, CodeDef.DELETE.getCode());
	}

}
