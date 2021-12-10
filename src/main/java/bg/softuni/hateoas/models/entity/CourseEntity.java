package bg.softuni.hateoas.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.validation.constraints.*;

@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity {
    private String name;
    private BigDecimal price;
    private boolean enabled;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    @DecimalMin(value = "1.00", inclusive = true)
    @DecimalMax(value = "1800.00", inclusive = true)
    @Digits(integer = 5, fraction = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
