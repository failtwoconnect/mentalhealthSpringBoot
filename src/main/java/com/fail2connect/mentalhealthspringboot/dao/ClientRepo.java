package com.fail2connect.mentalhealthspringboot.dao;

import com.fail2connect.mentalhealthspringboot.models.Client;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
    /**
     * Returns a list of all active clients in the system.
     *
     * @return a list of active clients
     */
    @Query("select c from Client c where c.active=true")
    List<Client> findallByActive();

    /**
     * Updates the active status of a client with the specified client ID.
     *
     * @param active the new active status value to be set
     * @param id the client ID of the client to be updated
     */
    @Modifying
    @Transactional
    @Query("update Client set active = ?1 where clientId = ?2")
    void updateInactiveClientByClientId(boolean active, int id);
}
