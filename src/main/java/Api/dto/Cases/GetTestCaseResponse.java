package Api.dto.Cases;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class GetTestCaseResponse {
    @Expose
    private boolean status;

    @Expose
    Result result;
}
