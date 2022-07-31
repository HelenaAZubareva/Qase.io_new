package Api.dto.Suites;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    @Expose
    public String title;
}
