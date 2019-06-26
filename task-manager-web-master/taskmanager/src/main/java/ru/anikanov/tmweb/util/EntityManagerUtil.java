package ru.anikanov.tmweb.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ru.anikanov.tmweb.entity.Project;
import ru.anikanov.tmweb.entity.Task;
import ru.anikanov.tmweb.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;


public class EntityManagerUtil {
    @ApplicationScoped
    private EntityManagerFactory factory() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/webtaskmanager");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT,
                "org.hibernate.dialect.MySQL5InnoDBDialect");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.SHOW_SQL, "true");
        final StandardServiceRegistryBuilder registryBuilder
                = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(User.class);
        sources.addAnnotatedClass(Task.class);
        sources.addAnnotatedClass(Project.class);
        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.buildSessionFactory();
    }

    @Default
    @Produces
    @RequestScoped
    private EntityManager getEntityManager() {
        return factory().createEntityManager();
    }
}
