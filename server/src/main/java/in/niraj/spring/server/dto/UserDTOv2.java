package in.niraj.spring.server.dto;

import in.niraj.spring.server.versioning.Versioned;

public class UserDTOv2 implements Versioned {
    private  String firstName;
    private  String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDTOv2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Versioned toVersion(int version) {
        if (version <= 1) {
            return new UserDTOv1(firstName);
        } else {
            return this;
        }
    }
}
