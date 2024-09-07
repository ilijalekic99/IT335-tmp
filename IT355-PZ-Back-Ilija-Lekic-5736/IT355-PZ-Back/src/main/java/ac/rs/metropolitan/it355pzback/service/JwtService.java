package ac.rs.metropolitan.it355pzback.service;

import ac.rs.metropolitan.it355pzback.entity.Role;
import ac.rs.metropolitan.it355pzback.dao.UserDao;
import ac.rs.metropolitan.it355pzback.entity.JwtRequest;
import ac.rs.metropolitan.it355pzback.entity.JwtResponse;
import ac.rs.metropolitan.it355pzback.entity.User;
import ac.rs.metropolitan.it355pzback.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();

        // Hardcode admin credentials
        if ("admin".equals(userName) && "admin123".equals(userPassword)) {
            UserDetails adminUserDetails = loadHardcodedAdmin();
            String adminToken = jwtUtil.generateToken(adminUserDetails);
            Set<Role> adminRoles = Set.of(new Role("Admin"));
            return new JwtResponse(new User("admin", "admin123", adminRoles), adminToken);
        }

        // Normal authentication for non-hardcoded users
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findById(userName).get();
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Hardcoded admin user
        if ("admin".equals(username)) {
            return loadHardcodedAdmin();
        }

        // Normal database authentication for other users
        User user = userDao.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private UserDetails loadHardcodedAdmin() {
        return new org.springframework.security.core.userdetails.User(
                "admin", // hardcoded admin username
                "admin123", // hardcoded admin password
                Set.of(new SimpleGrantedAuthority("ROLE_Admin")) // hardcoded role
        );
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
