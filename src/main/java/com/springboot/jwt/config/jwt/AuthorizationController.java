package com.springboot.jwt.config.jwt;

import com.springboot.jwt.dto.JwtCreateTokenRequest;
import com.springboot.jwt.dto.JwtCreatedTokenResponse;
import com.springboot.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/auth")
public class AuthorizationController {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JwtUtility jwtUtility;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody JwtCreateTokenRequest request) {
        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return ResponseEntity.ok(new JwtCreatedTokenResponse(token));
    }

}
