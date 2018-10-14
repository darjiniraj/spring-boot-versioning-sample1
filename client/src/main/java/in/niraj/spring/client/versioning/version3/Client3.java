package in.niraj.spring.client.versioning.version3;

import in.niraj.spring.client.versioning.BaseClient;
import in.niraj.spring.client.versioning.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * created by niraj on Oct, 2018
 */
public class Client3 extends BaseClient {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public Client3() {
        super(3);
    }

    public void doWork() throws IOException {
        User user = super.getAs("http://localhost:8080/user/1", User.class);
        log.info("Got v2 user: {}", user);
    }
}
