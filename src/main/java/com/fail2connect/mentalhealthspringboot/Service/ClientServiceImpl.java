package com.fail2connect.mentalhealthspringboot.Service;

import com.fail2connect.mentalhealthspringboot.dao.ClientRepo;
import com.fail2connect.mentalhealthspringboot.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }

    /**
     * Finds all clients in the system.
     *
     * @return a list of all clients
     */
    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    /**
     * Finds a client by their ID.
     *
     * @param id the ID of the client to find
     * @return the Client object with the specified ID
     * @throws RuntimeException if a client with the specified ID is not found
     */
    @Override
    public Client findByID(int id) {
        Optional<Client> result = clientRepo.findById(id);
        Client client = null;
        if(result.isPresent()){
            client = result.get();
        }
        else{
            throw new RuntimeException("Didn't find the client ID - " + id);
        }

        return client;
    }

    /**
     * Saves a client object to the database.
     *
     * @param client the client object to be saved
     * @return the saved client object
     */
    @Override
    public Client save(Client client) {
        return clientRepo.save(client);
    }

    /**
     * Deletes a client from the database with the specified ID.
     *
     * @param id the ID of the client to delete
     */
    @Override
    public void deleteByID(int id) {
        clientRepo.deleteById(id);
    }

    /**
     * Returns a list of all active clients in the system.
     *
     * @return a list of active clients
     */
    @Override
    public List<Client> findAllByActive() {
        return clientRepo.findallByActive();
    }

    /**
     * Updates the active status of a client with the specified client ID.
     *
     * @param active the new active status value to be set
     * @param id the client ID of the client to be updated
     */
    @Override
    public void updateInactiveClientByClientId(boolean active, int id) {
        clientRepo.updateInactiveClientByClientId(active, id);
    }
}
