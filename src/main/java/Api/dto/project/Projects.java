package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Projects {
    @Expose
    boolean status;
    @Expose
    Result result;
}
