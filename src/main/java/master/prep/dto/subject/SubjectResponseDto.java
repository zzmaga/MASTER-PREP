package master.prep.dto.subject;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectResponseDto {
    private UUID id;
    private String title;
    private String description;
}
