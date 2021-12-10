package bg.softuni.hateoas.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class StudentEntity extends BaseEntity {
    private int age;
    private String name;
    private List<OrderEntity> orders=new ArrayList<>();

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
@Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@OneToMany(mappedBy = "student",targetEntity = OrderEntity.class,fetch = FetchType.EAGER)
    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
