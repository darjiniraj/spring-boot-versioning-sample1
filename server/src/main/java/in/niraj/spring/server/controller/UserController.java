package in.niraj.spring.server.controller;

import in.niraj.spring.server.dto.UserDTO;
import in.niraj.spring.server.model.User;
import in.niraj.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public UserDTO get(@PathVariable final int id) {
        User user = service.get(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user.getFirstName(), user.getLastName(), user.geteMail());
    }

}
