package pl.pjatk.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Storage {

    private List<Ticket> tickets;

    public Storage() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void updateTicket(int id, Ticket ticket) {
        Optional<Ticket> ticketToUpdate = tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
        if (ticketToUpdate.isPresent()) {
            tickets.remove(ticketToUpdate.get());
            tickets.add(ticket);
        }
    }

    public void deleteTicket(int id) {
        Optional<Ticket> ticketToDelete = tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
        if (ticketToDelete.isPresent()) {
            tickets.remove(ticketToDelete.get());
        }
    }

    public Ticket getTicket(int id) {
        Optional<Ticket> ticket = tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
        return ticket.orElse(null);
    }
}
