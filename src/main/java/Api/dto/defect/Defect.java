package Api.dto.defect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defect {
    @Expose
    String title;
    @Expose
    @SerializedName("actual_result")
    String actualResult;
    @Expose
    int severity;

}
