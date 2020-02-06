package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.request.LoginFormRequest;
import ru.cft.shift.repetito.params.response.LoginResultResponse;
import ru.cft.shift.repetito.service.AuthenticationService;
import ru.cft.shift.repetito.service.TokenService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping("")
    public ResponseEntity<?> login(@RequestBody LoginFormRequest loginFormRequest, HttpServletResponse httpServletResponse) throws IOException {
        String password = loginFormRequest.getPassword();
        String email = loginFormRequest.getEmail();
        UserEntity userEntity = authenticationService.login(email, password);
        LoginResultResponse loginResultResponse = new LoginResultResponse();
        if (userEntity != null) {
            TokenEntity tokenEntity = tokenService.getToken(userEntity);
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUserEntity(userEntity);
            loginResultResponse.setUuid(tokenEntity.getUuid());
        } else {
            //httpServletResponse.sendError(406, "Email or Password are wrong");
            loginResultResponse.setSuccessful(false);
        }
        return ResponseEntity.ok(loginResultResponse);
    }
}
