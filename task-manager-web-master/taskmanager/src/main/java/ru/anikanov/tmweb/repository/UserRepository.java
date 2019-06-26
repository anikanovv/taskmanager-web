package ru.anikanov.tmweb.repository;

import lombok.NoArgsConstructor;
import ru.anikanov.tmweb.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public class UserRepository {
    @Inject
    private EntityManager entityManager;

    public void persist(User user) {
        entityManager.persist(user);
    }

    public List findAll() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    public User findOne(String login) {
        return (User) entityManager.createQuery("SELECT user FROM User user WHERE user.login=:login")
                .setParameter("login", login)
                .getSingleResult();
    }
}
