/*
 * **
 *  * @project : DeliX
 *  * @created : 26/04/2024, 01:53
 *  * @modified : 26/04/2024, 00:58
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */


package com.fsdm.pfe.delix.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsdm.pfe.delix.dto.response.UserResponseDto;
import com.fsdm.pfe.delix.entity.notification.FirebaseUser;
import com.fsdm.pfe.delix.entity.notification.Notification;
import com.fsdm.pfe.delix.model.enums.Role;
import com.fsdm.pfe.delix.model.enums.UserStatus;
import com.fsdm.pfe.delix.util.Constants;
import com.fsdm.pfe.delix.validation.user.UserValidate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Table(name = "users", indexes = {
        @Index(name = "index_email", columnList = "email"),
        @Index(name = "index_id", columnList = "id")
})
@Data
@RequiredArgsConstructor
@Entity
@DiscriminatorColumn(name = Role.USER_ROLE_NAME, discriminatorType = DiscriminatorType.STRING)
@UserValidate
public class User implements Serializable {
    protected final static String ROLE_PREFIX = "ROLE_";
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    FirebaseUser firebaseUser;

    @OneToMany(fetch = FetchType.LAZY)
    Collection<Notification> notifications;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @Email
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = Role.USER_ROLE_NAME, insertable = false, updatable = false, nullable = false)
    private String role;

    @Column(nullable = false)
    @Pattern(regexp = Constants.MOROCCAN_NUMBER_REGEXP)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(updatable = false)
    private Date registeredAt;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date lastUpdateDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private UserStatus status;

    @Column(unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token;

    @Column(unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String refreshToken;

    @Pattern(message = "CIN not valid", regexp = "^[A-Z0-9]{1,20}$")
    private String cin;

    private Date dateOfBirth;
    private double balance = 0;

    @URL(message = "not valid image url")
    private String image;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private PasswordResetToken passwordResetToken;

    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LoginLog> loginLogs;


    private Date verifiedAt;

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = new Date();
    }

    public boolean isEmailVerified() {
        return this.getStatus().equals(UserStatus.ACTIVE);
    }

    public UserResponseDto toUserResponseDto() {

        return new UserResponseDto(this.getId(),
                this.getFirstName(),
                this.getEmail(),
                this.getRole(),
                this.getPhoneNumber(),
                this.getAddress() != null ? this.getAddress().toAddressResponseDto() : null,
                this.getStatus(),
                this.getCin(),
                this.getDateOfBirth(),
                this.getImage()
        );
    }
    public void addNotification(Notification notification) {
        if (notifications == null) {
            notifications = new ArrayList<>();
        }
        notifications.add(notification);
    }

}