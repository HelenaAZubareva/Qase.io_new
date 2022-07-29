package Api.dto.defect;

import lombok.Data;

@Data
public class Result {
    int id;
    String title;
    String actual_result;
    String status;
}
