package org.example.library.auth;


import lombok.AllArgsConstructor;
import org.example.library.Exceptions.Auth.PasswordIsEmptyException;
import org.example.library.Exceptions.Auth.UserNameIsTakenException;
import org.example.library.models.User;
import org.example.library.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUsername(username);
        return new MyUserDetails(optional.orElseThrow(() -> new UsernameNotFoundException(username)));
    }

    public void register(UserDto userDto) {
        User user = new User();
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UserNameIsTakenException();
        }
        if (userDto.getPassword() != null && userDto.getPassword().isBlank()) {
            throw new PasswordIsEmptyException();
        }
        user.setUsername(userDto.getUsername());
        String password = userDto.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);
        userRepository.save(user);
    }
}
