package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

     @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String role;



    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Classroom> taughtClassrooms = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Repository> ownedRepositories = new ArrayList<>();

     @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<PullRequest> authoredPullRequests = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "reviewer")
    private List<PullRequest> reviewedPullRequests = new ArrayList<>();

     @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Commit> commits = new ArrayList<>();
}
