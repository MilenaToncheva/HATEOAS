package bg.softuni.hateoas.web.controllers;

import bg.softuni.hateoas.models.dto.OrderDto;
import bg.softuni.hateoas.models.dto.StudentDto;
import bg.softuni.hateoas.models.mapping.StudentMapper;
import bg.softuni.hateoas.service.StudentService;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDto>>> getStudents() {
        List<EntityModel<StudentDto>> studentDtos = this.studentService
                .findAll()
                .stream()
                .map(dto -> EntityModel.of(dto, createStudentLinks(dto)))
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(studentDtos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> updateStudent(@PathVariable ("id")String studentId,
                                                                 @RequestBody StudentDto student) {
        student.setId(studentId);
        StudentDto updatedStudent = this.studentService.updateStudent(student);
        return updatedStudent != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> getStudentById(@PathVariable("id") String studentId) {
        StudentDto student = this.studentService.findById(studentId);
        return ResponseEntity.ok(
                EntityModel.of(student, createStudentLinks(student)));

    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDto>>> getOrders(@PathVariable("id")String studentId){
      List<EntityModel<OrderDto>>orders=  this.studentService.getOrdersByStudent(studentId).stream()
              .map(dto->EntityModel.of(dto)).collect(Collectors.toList());

return ResponseEntity.ok(CollectionModel.of(orders));
    }
    private Link[] createStudentLinks(StudentDto studentDto) {
        List<Link> result = new ArrayList<>();
        Link selfLink = linkTo(methodOn(StudentController.class).getStudentById(studentDto.getId())).withSelfRel();
        result.add(selfLink);
        Link updateLink = linkTo(methodOn(StudentController.class).updateStudent(studentDto.getId(), studentDto)).withRel("Update");
        result.add(updateLink);
        Link ordersLink=linkTo(methodOn(StudentController.class).getOrders(studentDto.getId())).withRel("Orders");
        result.add(ordersLink);
        return result.toArray(new Link[0]);
    }

}
