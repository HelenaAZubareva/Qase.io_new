package Api.dto.Cases;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ResultApi {
    @Expose
    int id;

    @Expose
    public String title;
}
