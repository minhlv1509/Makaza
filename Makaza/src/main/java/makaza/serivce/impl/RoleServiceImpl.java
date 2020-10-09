package makaza.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import makaza.common.CodeDef;
import makaza.mapper.RolesMapper;
import makaza.model.Roles;
import makaza.serivce.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolesMapper rolesMapper;

	@Override
	public List<Roles> findAllRoles() {
		return this.rolesMapper.selectAll();
	}

	@Override
	public Roles findById(int id) {
		return this.rolesMapper.selectById(id);
	}

	@Override
	public void save(Roles role) {
		role.setDelFlg(CodeDef.NON_DELETE.getCode());
		this.rolesMapper.insertSelective(role);
	}

	@Override
	public void update(Roles role) {
		this.rolesMapper.update(role);
	}

	@Override
	public void delete(int id) {
		this.rolesMapper.deleteLogic(id, CodeDef.DELETE.getCode());
	}

}
