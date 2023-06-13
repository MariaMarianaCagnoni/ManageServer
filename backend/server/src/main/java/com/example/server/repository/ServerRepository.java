package com.example.server.repository;

import com.example.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mariana
 * @Project: server
 */
@Repository
public interface ServerRepository extends JpaRepository<Server,Long> {

    Server findByIpAddress(String ipAddress);


}
