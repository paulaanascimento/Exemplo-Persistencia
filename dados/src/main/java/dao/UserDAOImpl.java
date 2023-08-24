package dao;

import jakarta.persistence.*;
import model.User;

public class UserDAOImpl implements UserDAO {

    public User getUserByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);

            return query.getSingleResult();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public boolean emailExists(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class);
            query.setParameter("email", email);

            Long count = query.getSingleResult();
            return count > 0;

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void createUser(User newUser) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.merge(newUser);

            entityTransaction.commit();
        }
        catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }
}
