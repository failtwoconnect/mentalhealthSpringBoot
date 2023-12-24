package com.fail2connect.mentalhealthspringboot.Service;

import com.fail2connect.mentalhealthspringboot.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findByID(int id);
    Client save(Client client);
    void deleteByID(int id);
    List<Client> findAllByActive();
    void updateInactiveClientByClientId(boolean active, int id);
}
