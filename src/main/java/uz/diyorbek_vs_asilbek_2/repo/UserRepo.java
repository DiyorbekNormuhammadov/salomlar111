package uz.diyorbek_vs_asilbek_2.repo;

import jakarta.persistence.EntityManager;
import uz.diyorbek_vs_asilbek_2.entity.Users;

import java.util.List;

import static uz.diyorbek_vs_asilbek_2.config.MyListener.emf;

public class UserRepo {
    public static Users checkLogin(String phone, String password) {
        EntityManager entityManager = emf.createEntityManager();
        List<Users> resultList = entityManager.createQuery("select u from Users u where u.phone=:phon and u.password=:pass", Users.class).setParameter("phon", phone).setParameter("pass", password).getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

    public static List<Users> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        List<Users> users = entityManager.createQuery("select u from Users u", Users.class)
                .getResultList();
        return users;
    }
}
