package pl.pjatk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private Storage storage;

    public void createTicket(Ticket ticket) {
        storage.addTicket(ticket);
    }

    public void updateTicket(int id, Ticket ticket) {
        storage.updateTicket(id,ticket);
    }

    public void deleteTicket(int id) {
        storage.deleteTicket(id);
    }

    public Ticket getTicket(int id) {
        return storage.getTicket(id);
    }
}