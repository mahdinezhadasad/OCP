package IO.src.io;

import java.util.concurrent.atomic.*;
import java.util.stream.*;
 class TicketTaker {
    long ticketsSold;
    final AtomicInteger ticketsTaken;
    public TicketTaker() {
        ticketsSold = 0;
        ticketsTaken = new AtomicInteger(0);
    }
    
    
}