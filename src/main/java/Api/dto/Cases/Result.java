package Api.dto.Cases;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Result {
    @Expose
    private int id;
    @Expose
    private String title;
}
