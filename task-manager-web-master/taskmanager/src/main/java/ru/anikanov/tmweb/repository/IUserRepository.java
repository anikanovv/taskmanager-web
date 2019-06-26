package ru.anikanov.tmweb.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.User;

import java.util.List;

@Repository
public interface IUserRepository extends EntityRepository<User, String> {
    void persist(@NotNull final User user);

    void remove(@NotNull final User user);

    User merge(@NotNull final User user);

    List<User> findAll(@NotNull final String id);

    User findByLogin(@NotNull final String login);
}
