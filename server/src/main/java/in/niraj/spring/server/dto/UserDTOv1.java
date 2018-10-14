package in.niraj.spring.server.dto;

import in.niraj.spring.server.versioning.Versioned;

public class UserDTOv1 implements Versioned {
    private  String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserDTOv1(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Versioned toVersion(int version) {
        return this;
    }
}
