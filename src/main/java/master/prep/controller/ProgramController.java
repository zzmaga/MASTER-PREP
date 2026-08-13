package master.prep.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import master.prep.dto.program.ProgramRequestDto;
import master.prep.dto.program.ProgramResponseDto;
import master.prep.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController {
    private final ProgramService programService;

    @GetMapping("/{id}")
    public ResponseEntity<ProgramResponseDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(programService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProgramResponseDto> create(@Valid @RequestBody ProgramRequestDto programRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(programService.create(programRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProgramResponseDto>> getAll() {
        return ResponseEntity.ok().body(programService.getAll());
    }
}
