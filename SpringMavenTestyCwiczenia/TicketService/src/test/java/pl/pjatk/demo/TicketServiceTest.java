package pl.pjatk.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {
    @Mock
    private Storage storageMock;

    @InjectMocks
    private TicketService ticketService;

    private Ticket ticket;

    @Before
    public void setUp() {
        ticket = new Ticket(1, "Open", "John Doe", "Jane Smith");
    }

    @Test
    public void createTicket_shouldCallAddTicketMethodOfStorage() {
        ticketService.createTicket(ticket);
        verify(storageMock).addTicket(ticket);
    }

    @Test
    public void updateTicket_shouldCallUpdateTicketMethodOfStorage() {
        ticketService.updateTicket(1, ticket);
        verify(storageMock).updateTicket(1, ticket);
    }

    @Test
    public void deleteTicket_shouldCallDeleteTicketMethodOfStorage() {
        ticketService.deleteTicket(1);
        verify(storageMock).deleteTicket(1);
    }

    @Test
    public void getTicket_shouldCallGetTicketMethodOfStorage() {
        when(storageMock.getTicket(1)).thenReturn(ticket);
        Ticket result = ticketService.getTicket(1);
        assertEquals(ticket, result);
        verify(storageMock).getTicket(1);
    }
}
