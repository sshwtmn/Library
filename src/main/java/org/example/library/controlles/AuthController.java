package org.example.library.controlles;

import lombok.AllArgsConstructor;
import org.example.library.Exceptions.Auth.AuthException;
import org.example.library.Exceptions.Auth.PasswordIsEmptyException;
import org.example.library.Exceptions.Auth.UserNameIsTakenException;
import org.example.library.auth.AuthService;
import org.example.library.auth.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registration")
    public String registration(@RequestBody UserDto userDto) {
        try {
            authService.register(userDto);
            return "success";
        }catch (PasswordIsEmptyException e){
            return e.getMessage();
        }catch (UserNameIsTakenException e){
            return "user name is taken";
        }
    }

    @GetMapping("login")
    public ResponseEntity<?> login(){
        return ResponseEntity.ok().build();
    }
}
