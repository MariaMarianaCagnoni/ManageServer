package com.example.server.service;

import com.example.server.model.Server;

import java.util.Collection;

/**
 * @author mariana
 * @Project: server
 */
public interface ServerService {

    Server createServer(Server server);

    Collection<Server> listServers(int limit);

    Server getServerById(Long id);

    Server updateServer(Server server);

    Boolean deleteServerById(Long id);
}
