package bg.softuni.hateoas.repository;

import bg.softuni.hateoas.models.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,String> {
}
