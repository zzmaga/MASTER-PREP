package master.prep.dto.program;

import java.util.UUID;

public record ProgramResponseDto(
        UUID id,
        String code,
        String title,
        String description
) {
}