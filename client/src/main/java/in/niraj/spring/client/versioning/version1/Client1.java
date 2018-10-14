package in.niraj.spring.client.versioning.version1;

import in.niraj.spring.client.versioning.BaseClient;
import in.niraj.spring.client.versioning.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * created by niraj on Oct, 2018
 */
public class Client1 extends BaseClient {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public Client1() {
        super(1);
    }

    public void doWork() throws IOException {
        User user = super.getAs("http://localhost:8080/user/1", User.class);
        log.info("Got v1 user: {}", user);
    }
}
