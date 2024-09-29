package com.await.springmvcblog.mapper;

import com.await.springmvcblog.dto.UserDTO;
import com.await.springmvcblog.model.User;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between User entity and UserDTO.
 * This interface uses MapStruct to generate the required implementation automatically.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user the User entity to be converted
     * @return the corresponding UserDTO
     */
    UserDTO toDTO(User user);

    /**
     * Converts a UserDTO to a User entity.
     *
     * @param userDTO the data transfer object to be converted
     * @return the corresponding User entity
     */
    User toEntity(UserDTO userDTO);
}
