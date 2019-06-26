package ru.anikanov.tmweb.Service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.User;
import ru.anikanov.tmweb.repository.IUserRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Transactional
public class UserService implements Serializable {
    @Inject
    private IUserRepository userRepository;


    public void persist(@NotNull final User user) {
        userRepository.persist(user);
    }

    public void remove(@NotNull final User user) {
        userRepository.remove(user);
    }

    public User merge(@NotNull final User user) {
        return userRepository.merge(user);
    }

    public List<User> findAll(@NotNull final String id) {
        return userRepository.findAll(id);
    }

    public User findByLogin(@NotNull final String login) {
        return userRepository.findByLogin(login);
    }

}
