package makaza.serivce;

import java.util.List;

import makaza.model.Roles;

public interface RoleService {

	List<Roles> findAllRoles();

	Roles findById(int id);

	void save(Roles role);

	void update(Roles role);

	void delete(int id);
}
