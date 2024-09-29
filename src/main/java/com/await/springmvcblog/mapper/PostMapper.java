package com.await.springmvcblog.mapper;

import com.await.springmvcblog.dto.PostDTO;
import com.await.springmvcblog.model.Post;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Post and PostDTO.
 * Utilizes MapStruct to automatically generate the implementation.
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    /**
     * Converts a Post entity to a PostDTO.
     *
     * @param post the Post entity to be converted
     * @return the corresponding PostDTO
     */
    PostDTO toDTO(Post post);

    /**
     * Converts a PostDTO to a Post entity.
     *
     * @param postDTO the data transfer object to be converted
     * @return the corresponding Post entity
     */
    Post toEntity(PostDTO postDTO);
}
