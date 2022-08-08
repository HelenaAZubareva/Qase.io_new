package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    String title;
    @Expose
    String code;
    @Expose
    String description;
    @Expose
    String access;
    @Expose
    String group;
    @Expose(serialize = false)
    Counts counts;
}
