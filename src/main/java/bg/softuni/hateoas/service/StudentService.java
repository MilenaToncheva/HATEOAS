package bg.softuni.hateoas.service;

import bg.softuni.hateoas.models.dto.OrderDto;
import bg.softuni.hateoas.models.dto.StudentDto;
import org.springframework.hateoas.EntityModel;

import java.util.List;


public interface StudentService {
    StudentDto findById(String id);

    StudentDto updateStudent(StudentDto student);

    List<StudentDto> findAll();

    List<OrderDto> getOrdersByStudent(String studentId);
}
