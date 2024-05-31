/*
 * **
 *  * @project : DeliX
 *  * @created : 29/04/2024, 18:29
 *  * @modified : 29/04/2024, 18:29
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity

public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;

    private String userAgent;
    private String ipAddress;
    private boolean loginStatus;
    private String loginMethod;

}