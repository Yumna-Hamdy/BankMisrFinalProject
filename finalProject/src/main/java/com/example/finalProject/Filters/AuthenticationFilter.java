//package com.example.finalProject.Filters;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.example.finalProject.Entities.RegisteredDetails;
//import com.example.finalProject.Services.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
//
//@AllArgsConstructor
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    @Autowired
//    private UserService userService;
//    private AuthenticationManager authenticationManager;
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String email =request.getParameter("email");
//        String password =request.getParameter("password");
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
//        return authenticationManager.authenticate(authenticationToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
//        User user = (User)authResult.getPrincipal();
//        Algorithm algorithm = Algorithm.HMAC256("meh");
//        int expiresIn = 60*60*24;
//        String accessToken = JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + expiresIn)).sign(algorithm);
//        com.example.finalProject.Entities.User appUser;
//        appUser = userService.getUserByEmail(user.getUsername());
//        System.out.println(appUser);
//        RegisteredDetails registeredDetails = new RegisteredDetails("Bearer "+accessToken,
//                appUser.getUsername(),appUser.getEmail(),appUser.getMobile(),appUser.getId(),expiresIn);
//
//        Map<String,String> returnedBody = new HashMap<>();
//        returnedBody.put("access_token", "Bearer "+accessToken);
//        returnedBody.put("username", appUser.getUsername());
//        returnedBody.put("email", appUser.getEmail());
//        returnedBody.put("mobile", appUser.getMobile());
//        response.setContentType(APPLICATION_JSON_VALUE);
//        new ObjectMapper().writeValue(response.getOutputStream(),registeredDetails);
//        //response.setHeader("access_token","Bearer "+accessToken);
//
//
//    }
//}
