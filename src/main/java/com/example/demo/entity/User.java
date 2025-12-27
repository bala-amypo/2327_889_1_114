// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue
//     private Long id;

//     @Column(unique = true)
//     private String email;

//     private String password;

//     private String role = "STAFF";

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }
package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    private String role = "STAFF";

    public User() {}

    public User(String name, String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role != null ? role : "STAFF";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}