package in.niraj.spring.server.service;

import in.niraj.spring.server.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private Map<Integer, User> users = new HashMap<>();

    public void add(final User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> get(final int id) {
        return Optional.ofNullable(users.get(id));
    }

    @PostConstruct
    public void init() {
        add(new User(0, "Niraj", "Darji", "niraj.darji@test.com"));
        add(new User(1, "TestFirstName", "lastName", "test.test@test.com"));
    }
}
