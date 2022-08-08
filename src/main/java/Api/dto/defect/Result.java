package Api.dto.defect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    @SerializedName("actual_result")
    String actualResult;
    @Expose
    String status;
}
