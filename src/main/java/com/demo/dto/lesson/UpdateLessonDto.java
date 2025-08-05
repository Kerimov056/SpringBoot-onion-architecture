package com.demo.dto.lesson;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLessonDto {
	@NotNull(message = "subject null ola bilmez ! mutleq olmalidir.!!!")
    @Size(min = 3, max = 80, message = "min 3 max 80 olmalidir")
    private String subject;

    @NotNull(message = "startLessonTime null ola bilmez ! mutleq olmalidir.!!!")
    private LocalDateTime startLessonTime;

    @NotNull(message = "grade null ola bilmez ! mutleq olmalidir.!!!")
    private Integer grade;

    @NotNull(message = "teacher_id null ola bilmez ! mutleq olmalidir.!!!")
    private UUID teacher_id;
}
