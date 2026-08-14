package master.prep.mapstruct;

import master.prep.dto.subject.SubjectRequestDto;
import master.prep.dto.subject.SubjectResponseDto;
import master.prep.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectResponseDto toResponseDto(Subject entity);

    @Mapping(target = "id", ignore = true)
    Subject toEntity(SubjectRequestDto dto);
}
