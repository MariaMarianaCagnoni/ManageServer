package com.example.server.controller;

import com.example.server.enumeration.Status;
import com.example.server.model.Response;
import com.example.server.model.Server;
import com.example.server.service.ServerService;
import com.example.server.service.implementation.ServerServiceImplementation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

import static java.util.Map.of;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author mariana
 * @Project: server
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class ServerController {

    private final ServerServiceImplementation serverServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(of("servers", serverServiceImplementation.listServers(30)))
                        .message("server retrieve")
                        .status(OK)

                        .statusCode(200)
                        .build()
        );
    }

    @GetMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(of("servers", server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping success" : "Ping failed")
                        .status(CREATED)
                        .statusCode(201)
                        .build()
        );
    }

    @PostMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> createServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverServiceImplementation.ping(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(of("servers", serverServiceImplementation.createServer(server)))
                        .message("server created")
                        .status(OK)
                        .statusCode(200)
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(of("servers", serverServiceImplementation.getServerById(id)))
                        .message("server retrieve")
                        .status(OK)
                        .statusCode(200)
                        .build()
        );
    }
}


