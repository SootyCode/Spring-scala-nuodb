package org.nascency.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@org.hibernate.annotations.BatchSize(size = 10)
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id = null;

    @Version
    @Column(name = "OBJ_VERSION")
    private int version = 0;

    @Column(name = "FIRSTNAME", length = 255, nullable= false)
    private String firstname;

    @Column(name = "LASTNAME", length= 255, nullable= false)
    private String lastname;

    //@Column(name = "USERNAME", length = 16, nullable = false, unique = true) -- example taken from JPA book, not immutable
    @Column(name = "USERNAME", length = 16, nullable = false, unique = true, updatable = false)
    private String username; // Unique and immutable

    @Column(name = "`PASSWORD`", length = 12, nullable = false)
    private String password;

    @Column(name = "EMAIL", length = 255 , nullable = false)
    private String email;

    @Column(name = "RANK", nullable = false)
    private int ranking = 0;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean admin = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date created = new Date();

    public User()
    {
    }

    public User(String firstname, String lastname, String username, String password, String email, int ranking, boolean admin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ranking = ranking;
        this.admin = admin;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getRanking() {
        return ranking;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Date getCreated() {
        return created;
    }
}
