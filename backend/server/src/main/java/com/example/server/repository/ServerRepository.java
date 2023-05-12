package com.example.server.repository;

import com.example.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mariana
 * @Project: server
 */

public interface ServerRepository extends JpaRepository<Server,Long> {

    Server findByIpAddress(String ipAddress);


}
