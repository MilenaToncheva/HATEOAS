package bg.softuni.hateoas.models.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity extends BaseEntity {
    private StudentEntity student;
    private CourseEntity course;

    @ManyToOne(optional = false)
    @JoinColumn(name="student_id", referencedColumnName = "id")
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
@ManyToOne(optional = false)
@JoinColumn(name="course_id",referencedColumnName = "id")
    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
}
