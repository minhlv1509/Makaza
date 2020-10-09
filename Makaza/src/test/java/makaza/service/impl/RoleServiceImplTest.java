package makaza.service.impl;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import makaza.model.Roles;
import makaza.serivce.RoleService;

@RunWith(SpringRunner.class)
@Transactional 
@SpringBootTest
public class RoleServiceImplTest {
	
	@Autowired
	private RoleService roleService;
	
	public static final int ROLE_ID_EXISTED = 1;
	public static final int ROLE_ID_NOT_EXISTED = 9999;
	
	public static final String ROLE_NAME_TO_SAVE = "role_name_test_save";
	public static final String ROLE_NAME_TO_UPDATE = "role_name_test_update";
	
	/** test findAllRoles */
	@Test
    public void testFindAllRoles() {
        Assert.assertEquals(2, this.roleService.findAllRoles().size());
    }
	
	/** test findById */
	@Test
    public void testFindById() {
		Roles role = this.roleService.findById(ROLE_ID_EXISTED);
		Assert.assertTrue(ROLE_ID_EXISTED == role.getId());
    }
	
	/** test save */
	@Test
    public void testSave() {
		try {
			Roles role = new Roles();
			role.setRoleName(ROLE_NAME_TO_SAVE);
			role.setId(ROLE_ID_NOT_EXISTED);
			this.roleService.save(role);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
	
	/** test update */
	@Test
    public void testUpdate() {
		try {
			Roles expected = new Roles();
			expected.setRoleName(ROLE_NAME_TO_UPDATE);
			expected.setId(ROLE_ID_EXISTED);
			this.roleService.update(expected);

			Roles actual = this.roleService.findById(ROLE_ID_EXISTED);
			
			Assert.assertEquals(expected.getRoleName(), actual.getRoleName());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
	
	/** test delete */
	@Test
    public void testDelete() {
		try {
			this.roleService.delete(ROLE_ID_EXISTED);

			Roles actual = this.roleService.findById(ROLE_ID_EXISTED);
			
			Assert.assertTrue(!Objects.nonNull(actual));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
    }
}
