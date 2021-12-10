package bg.softuni.hateoas.models.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "students") //for better representation (instead of StudentsDTO)
public class StudentDto {
    private String id;
    private int age;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
