package Api.dto.Suites;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ErrorResult {
    @Expose
    Boolean status;
    @Expose
    String errorMessage;

}
