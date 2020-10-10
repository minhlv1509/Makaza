package makaza.serivce;

import java.util.List;

import makaza.model.Roles;

/**
 * RoleService
 * @author Minh
 */
public interface RoleService {

	/**
	 * Get all roles
	 * @return roles
	 */
	List<Roles> findAllRoles();

	/**
	 * Get role by id
	 * @param id id
	 * @return role
	 */
	Roles findById(int id);

	/**
	 * Add role to DB
	 * @param role role
	 */
	void save(Roles role);

	/**
	 * Update role
	 * @param role role
	 */
	void update(Roles role);

	/**
	 * delete login role (DEL_FLG=0)
	 * @param id id
	 */
	void delete(int id);
}
