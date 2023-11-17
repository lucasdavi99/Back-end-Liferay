package com.liferay.CommunityApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liferay.CommunityApp.enums.CommunityPrivate;
import com.liferay.CommunityApp.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_COMMUNITIES")
public class CommunityModel extends RepresentationModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserModel author;

    private UserRole authorRole = UserRole.ADMIN;

    private CommunityPrivate privacy;

    private LocalDateTime creation;

    private String location;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name = "community_members",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserModel> members = new ArrayList<>();

    private byte profilePhoto;
    private byte coverPhoto;


//@OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
//private List<PostModel> posts;

    public <T> CommunityModel(Object o, String inglesDosCria, String s, String s1, CommunityPrivate communityPrivate, UserModel u3, List<T> list) {
    }

}
