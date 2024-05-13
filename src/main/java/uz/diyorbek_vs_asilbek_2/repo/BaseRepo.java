package uz.diyorbek_vs_asilbek_2.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import uz.diyorbek_vs_asilbek_2.entity.Users;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static uz.diyorbek_vs_asilbek_2.config.MyListener.emf;


public class BaseRepo<T, ID> {
    private final Class<T> persistanceClass;

    public BaseRepo() {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.persistanceClass = clazz;
    }



    public static List<Users> findAllUser() {
        EntityManager entityManager = emf.createEntityManager();
        List<Users> users = entityManager.createQuery("select u from Users u", Users.class)
                .getResultList();
        return users;

    }

    public void save(T t) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }
    }

    public void update(T t) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete entity: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(ID id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            T entity = entityManager.find(persistanceClass, id);
            if (entity != null) {
                System.out.println("entity: " + entity);
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
            } else {
                throw new EntityNotFoundException("Entity not found for ID: " + id);
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete entity: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    public T findById(ID id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(persistanceClass, id);
    }
}
