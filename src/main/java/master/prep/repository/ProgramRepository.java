package master.prep.repository;

import master.prep.dto.program.ProgramResponseDto;
import master.prep.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProgramRepository extends JpaRepository<Program, UUID> {
    boolean existsByCode(String code);
}
