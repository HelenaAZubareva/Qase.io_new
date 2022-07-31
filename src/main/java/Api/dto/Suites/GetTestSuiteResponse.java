package Api.dto.Suites;

import Api.dto.Cases.Result;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class GetTestSuiteResponse {
    @Expose
    private boolean status;

    @Expose
    Result result;
}
