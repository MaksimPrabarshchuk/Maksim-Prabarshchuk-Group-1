package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;

import dao.UserRepository;
import model.User;

@ApplicationScoped
public class UserService {

    private QueueConnectionFactory qconFactory;
    private QueueConnection qcon;
    private QueueSession qsession;
    private static QueueSender qsender;
    private Queue queue;
    private static TextMessage msg;

    @Inject
    private EntityManager em;

    @Inject
    private UserRepository userRepository;

    public UserService() {
        try {
            InitialContext ctx = new InitialContext();
            qconFactory = (QueueConnectionFactory) ctx.lookup("/ConnectionFactory");
            qcon = qconFactory.createQueueConnection();
            qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queue = (Queue) ctx.lookup("queue/newUsers");
            qsender = qsession.createSender(queue);
            msg = qsession.createTextMessage();
            qcon.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void register(User user) throws Exception {
        em.persist(user);
        if (msg != null && qsender != null) {
            // Send notification message about new user
            msg.setText("New user with name " + user.getFirstName()
                    + "successfully registered!");
            qsender.send(msg);
        }
    }
}
