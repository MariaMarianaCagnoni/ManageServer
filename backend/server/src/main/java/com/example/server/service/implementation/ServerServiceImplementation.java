package com.example.server.service.implementation;

import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import com.example.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public Server create(Server server) {
        log.info("Saving new sever: {}", server.getName());
        server.setImageUrl(setServerImgUrl());
        return null;
    }


    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String setServerImgUrl() {
        return null;
    }
}
