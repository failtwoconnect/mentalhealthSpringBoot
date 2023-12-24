package com.fail2connect.mentalhealthspringboot.controllers;

import com.fail2connect.mentalhealthspringboot.Service.ClientService;
import com.fail2connect.mentalhealthspringboot.Service.NumberService;
import com.fail2connect.mentalhealthspringboot.models.Client;
import com.fail2connect.mentalhealthspringboot.models.TherapyNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;

    }

    /**
     * Adds a new client.
     *
     * @param model the model object for the view
     * @return the name of the view template to render
     */
    @GetMapping("/add-client")
    public String AddClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "clients/add-client";
    }

    /**
     * Displays the admin view for clients.
     *
     * @param model the model object for the view
     * @return the name of the view template to render
     */
    @GetMapping("/admin-view")
    public String admin_view(Model model){
        List<Client> clientList = clientService.findAllByActive();
        model.addAttribute("client", clientList);

        return "clients/admin-view";
    }

    /**
     * Saves a client.
     *
     * @param client the client object to be saved
     * @return the redirection URL to the admin view template
     */
    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.save(client);
        return "redirect:/clients/admin-view";
    }

    /**
     * Retrieves a client's information by their ID and displays a form for updating the client.
     *
     * @param id    the ID of the client to be updated
     * @param model the model object for the view
     * @return the name of the view template to render for updating the client
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model){
        Client client = clientService.findByID(id);
        model.addAttribute("client", client);
        return "clients/add-client";
    }

    /**
     * Deletes a client by their ID and redirects to the admin view template.
     *
     * @param id the ID of the client to be deleted
     * @return the redirection URL to the admin view template
     */
    @GetMapping("/delete")
    public String delete (@RequestParam("id") int id){
        clientService.deleteByID(id);
        return "redirect:/clients/admin-view";
    }

    /**
     * Displays all the clients in the model and returns the name of the view template to render.
     *
     * @param model the model object for the view
     * @return the name of the view template to render
     */
    @GetMapping("/all-clients")
    public String showAllClients(Model model){
        List<Client> clientList = clientService.findAll();
        model.addAttribute("client", clientList);
        return "clients/all-clients";
    }

    /**
     * Updates the active status of a client with the given ID.
     *
     * @param id      the ID of the client to update
     * @param active  the new active status of the client
     * @param model   the model object for the view
     * @return the redirection URL to the all-clients view template
     */
    @GetMapping("/updateActive")
    public String updateActiveStatus(@RequestParam("id") int id,
                                     @RequestParam("activeStatus") boolean active,
                                     Model model){
        clientService.updateInactiveClientByClientId(active, id);
        return "redirect:/clients/all-clients";
    }
}
