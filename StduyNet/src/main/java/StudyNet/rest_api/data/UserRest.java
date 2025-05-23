package StudyNet.rest_api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
public class UserRest {

    @Schema(title="사용자 ID", description = "사용자 ID는 자동 생성됩니다.")
    private Integer id;

    @Schema(title="사용자 이름", description = "사용자 이름을 입력합니다.")
    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요.")
    private String name;
    @Schema(title="등록일", description = "사용자의 등록일을 입력해주세요.")
    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private LocalDate joinDate;

    @Schema(title=" 비밀번호", description = "사용자의 비밀번호를 입력해주세요.")
    @JsonIgnore
    private String password;
    @Schema(title="주민번호", description = "사용자의 주미번호를 입력해주세요.")
    @JsonIgnore
    private String ssn;
    @Schema(title="등급", description = "사용자의 등급을 입력해주세요.")
    @JsonIgnore
    private String grade;

}
