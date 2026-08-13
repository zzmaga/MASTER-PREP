package master.prep.mapstruct;

import master.prep.dto.program.ProgramRequestDto;
import master.prep.dto.program.ProgramResponseDto;
import master.prep.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // Позволяет внедрять маппер как Spring Bean (@Autowired)
public interface ProgramMapper {

    // Преобразование Entity -> ResponseDto (для отправки клиенту)
    ProgramResponseDto toResponseDto(Program entity);

    // Преобразование RequestDto -> Entity (для сохранения в БД)
    @Mapping(target = "id", ignore = true) // Игнорируем ID, его сгенерирует Hibernate
    Program toEntity(ProgramRequestDto dto);

    // Обновление существующей сущности из DTO (при редактировании)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProgramRequestDto dto, @MappingTarget Program entity);
}