package ua.edu.chdtu.deanoffice.mobile.backend.security;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationUser;

import java.util.ArrayList;

@Getter
@Setter
public class CurrentUserDetails extends org.springframework.security.core.userdetails.User {

    private int id;

    public CurrentUserDetails(ApplicationUser user) {
        super(user.getUsername(), user.getPassword(), new ArrayList<>());
        this.id = user.getId();
    }
}