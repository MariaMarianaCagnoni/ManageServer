package com.example.server.model;

import com.example.server.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mariana
 * @Project: server
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SERVER")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "ip_address",unique = true)
    @NotEmpty(message = "IP address cannot be empty or null")
    private String ipAddress;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "memory",nullable = false)
    private String memory;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "image_url",nullable = false)
    private String imageUrl;

    @Enumerated
    @Column(name = "status")
    private Status status;



}
