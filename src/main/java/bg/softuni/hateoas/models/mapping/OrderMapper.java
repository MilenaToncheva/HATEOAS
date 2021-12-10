package bg.softuni.hateoas.models.mapping;

import bg.softuni.hateoas.models.dto.OrderDto;
import bg.softuni.hateoas.models.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto mapOrderEntityToDto(OrderEntity orderEntity);
}
