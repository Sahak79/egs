package com.egs.common.data.model;

import javax.persistence.*;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Entity
@Table(name = "files")
public class UserFile {

    public UserFile() {}

    public UserFile(User user, String filePath, String fileName) {
        this.user = user;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", insertable =  false, updatable = false)
    private User user;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "fileName")
    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "UserFile{" +
                "id=" + id +
                ", user=" + user.getFirstName() +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
