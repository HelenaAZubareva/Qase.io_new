package Api.dto.defect;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Status {
    @Expose
    boolean status;
    @Expose
    Result result;
}
