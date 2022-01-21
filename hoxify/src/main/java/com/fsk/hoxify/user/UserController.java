package com.fsk.hoxify.user;


import com.fsk.hoxify.entity.User;
import com.fsk.hoxify.service.UserService;
import com.fsk.hoxify.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private GenericResponse response = new GenericResponse();

    private final UserService userService;



    @CrossOrigin
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createUser(@RequestBody final User user) {
        LOG.info(user.toString());
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created.");
    }

}
