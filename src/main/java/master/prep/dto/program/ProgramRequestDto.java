package master.prep.dto.program;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequestDto{
        @NotBlank(message = "Код программы не может быть пустым")
        @Size(max = 50, message = "Код программы не должен превышать 50 символов")
        private String code;

        @NotBlank(message = "Название программы не может быть пустым")
        @Size(max = 255, message = "Название не должно превышать 255 символов")
        private String title;

        private String description;
}

