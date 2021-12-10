package bg.softuni.hateoas.service;

import bg.softuni.hateoas.models.dto.OrderDto;
import bg.softuni.hateoas.models.entity.OrderEntity;
import bg.softuni.hateoas.models.entity.StudentEntity;
import bg.softuni.hateoas.models.mapping.OrderMapper;
import bg.softuni.hateoas.models.mapping.StudentMapper;
import bg.softuni.hateoas.models.dto.StudentDto;
import bg.softuni.hateoas.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final OrderMapper orderMapper;


    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, OrderMapper orderMapper) {
        this.studentRepository = studentRepository;

        this.studentMapper = studentMapper;
        this.orderMapper = orderMapper;
    }


    @Override
    public StudentDto findById(String id) {
        return this.studentRepository.findById(id).map(s -> studentMapper.mapEntityToDto(s)).orElseThrow();
    }

    @Override
    public StudentDto updateStudent(StudentDto student) {
        StudentEntity studentEntity = this.studentRepository.findById(student.getId()).orElse(null);
        if (studentEntity == null) {
            return null;
        }
        studentEntity.setAge(student.getAge());
        studentEntity.setName(student.getName());
        studentEntity = this.studentRepository.save(studentEntity);

        return studentMapper.mapEntityToDto(studentEntity);
    }

    @Override
    public List<StudentDto> findAll() {
        return this.studentRepository.findAll().stream()
                .map(this.studentMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByStudent(String studentId) {
        StudentEntity studentEntity = this.studentRepository.findById(studentId).orElse(null);
        if (studentEntity != null) {
            return studentEntity.getOrders().stream().map(this::mapOrderEntityToDto).collect(Collectors.toList());
        } else {
            return null;
        }
    }
    private OrderDto mapOrderEntityToDto(OrderEntity orderEntity){
        OrderDto orderDto=new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setCourseId(orderEntity.getCourse().getId());
        orderDto.setStudentId(orderEntity.getStudent().getId());
        return orderDto;
    }
}
