package com.egs.common.data.model;

import com.egs.common.data.model.converter.UserProfileConverter;
import com.egs.common.data.model.lcp.UserProfile;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Entity
@Table(name = "user")
public class User {

    public User() {}

    public User(User user) {
        this.id = user.id;
        this.profile = user.profile;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "profile_id")
    @Convert(converter = UserProfileConverter.class)
    private UserProfile profile;

    @NotEmpty(message = "{err.field.first.name.required}")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "{err.field.last.name.required}")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "{err.field.email.invalid}")
    @NotEmpty(message = "{err.field.email.required}")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity=UserFile.class, mappedBy="user", cascade = CascadeType.ALL)
    private Set<UserFile> files;

    public Set<UserFile> getFiles() {
        return files;
    }

    public void setFiles(Set<UserFile> files) {
        this.files = files;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profile=" + profile +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", files=" + files +
                '}';
    }
}

