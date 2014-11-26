package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.UserRepository;
import model.User;

@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager em;

    @Inject
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void register(User user) throws Exception {
        em.persist(user);
    }
}
