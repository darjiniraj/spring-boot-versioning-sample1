package in.niraj.spring.server.dto;

import in.niraj.spring.server.versioning.Versioned;

public class UserDTO implements Versioned {
    private String firstName;
    private String lastName;
    private String eMail;

    public UserDTO(String firstName, String lastName, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public Versioned toVersion(int version) {
        if (version <= 2) {
            return new UserDTOv2(firstName, lastName)
                    .toVersion(version);
        } else {
            return this;
        }
    }
}
