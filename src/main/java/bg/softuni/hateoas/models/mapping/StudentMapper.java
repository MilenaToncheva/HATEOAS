package bg.softuni.hateoas.models.mapping;

import bg.softuni.hateoas.models.dto.StudentDto;
import bg.softuni.hateoas.models.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto mapEntityToDto(StudentEntity studentEntity);


}
