package ua.edu.chdtu.deanoffice.mobile.backend.security;

import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationUser;
import ua.edu.chdtu.deanoffice.mobile.backend.applicationUser.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if(applicationUser == null)
            throw new UsernameNotFoundException(username);

        return new CurrentUserDetails(applicationUser);
    }
}

