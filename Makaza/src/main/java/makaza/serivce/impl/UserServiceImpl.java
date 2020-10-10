package makaza.serivce.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import makaza.model.CustomUserDetails;
import makaza.model.UserDetail;
import makaza.serivce.UserDetailService;

/**
 * UserServiceImpl
 * @author Minh
 */
@Service
public class UserServiceImpl implements UserDetailsService {

	/** UserDetailService */
	@Autowired
	private UserDetailService userDetailService;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail user = this.userDetailService.findById(username);

		if (!Objects.nonNull(user)) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

}
