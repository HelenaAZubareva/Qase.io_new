package Api.dto.Suites;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Result {
    @Expose
    private float id;

    @Expose
    private String title;
}
