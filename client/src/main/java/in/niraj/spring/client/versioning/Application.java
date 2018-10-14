package in.niraj.spring.client.versioning;

import in.niraj.spring.client.versioning.version1.Client1;
import in.niraj.spring.client.versioning.version2.Client2;
import in.niraj.spring.client.versioning.version3.Client3;

public class Application {
    public static void main(String... argv) throws Exception {
        new Client1().doWork();
        new Client2().doWork();
        new Client3().doWork();
    }
}
