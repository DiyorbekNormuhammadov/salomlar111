package uz.diyorbek_vs_asilbek_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.diyorbek_vs_asilbek_2.repo.BaseRepo;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users extends BaseRepo<Users,Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String password;
}
