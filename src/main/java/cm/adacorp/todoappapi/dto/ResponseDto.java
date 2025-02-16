package cm.adacorp.todoappapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto {
    private String statusCode;
    private String statusMessage;
}
