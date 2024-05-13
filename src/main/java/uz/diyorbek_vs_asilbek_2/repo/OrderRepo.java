package uz.diyorbek_vs_asilbek_2.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import uz.diyorbek_vs_asilbek_2.entity.Orders;

import java.util.List;

import static uz.diyorbek_vs_asilbek_2.config.MyListener.emf;


public class OrderRepo {
    public static List<Orders> all() {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Orders> selectTFromGroupT = entityManager.createQuery("select t from Orders t", Orders.class);
        return selectTFromGroupT.getResultList();
    }
}
