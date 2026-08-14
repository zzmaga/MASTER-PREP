package master.prep.dto.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRequestDto {

    @NotBlank(message = "Название предмета обязательно")
    @Size(min = 1, max = 255, message = "Название предмета должно быть от 1 до 255 символов")
    private String title;

    private String description;
}