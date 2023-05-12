package com.example.server.service;

import com.example.server.model.Server;

import java.util.Collection;

/**
 * @author mariana
 * @Project: server
 */
public interface ServerService {

    Server create(Server server);

    Collection<Server> list(int limit);

    Server get(Long id);

    Server update(Server server);

    Boolean delete(Long id);
}
