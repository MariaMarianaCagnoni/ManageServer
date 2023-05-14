package com.example.server.service.implementation;

import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import com.example.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.example.server.enumeration.Status.SERVER_DOWN;
import static com.example.server.enumeration.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

/**
 * @author mariana
 * @Project: server
 */

@Service
@Transactional
@Log4j2
public class ServerServiceImplementation implements ServerService {

    private final ServerRepository serverRepository;

    public ServerServiceImplementation(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public Server createServer(Server server) {
        log.info("Saving new sever: {}", server.getName());
        server.setImageUrl(setServerImgUrl());
        return this.serverRepository.save(server);
    }


    @Override
    public Collection<Server> listServers(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(of(0, limit)).toList();
    }

    @Override
    public Server getServerById(Long id) {
        log.info("Fetchinh servers by id:{}", id);
        return this.serverRepository.findById(id).get();
    }

    @Override
    public Server updateServer(Server server) {
        log.info("Updating server: {}", server.getName());
        return this.serverRepository.save(server);

    }

    @Override
    public Boolean deleteServerById(Long id) {

        log.info("deleting server by ID: {}", id);
        this.serverRepository.deleteById(id);
        return TRUE;
    }

    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP:{}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10_000) ? SERVER_UP : SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    private String setServerImgUrl() {
        String[] imageName = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/images" +
                imageName[ new Random().nextInt(4)]).toUriString();
    }
}
