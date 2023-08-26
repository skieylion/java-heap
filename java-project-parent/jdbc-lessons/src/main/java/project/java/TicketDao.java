package project.java;

public class TicketDao {

    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {

    }

    private static TicketDao getInstance() {
        return INSTANCE;
    }
}
