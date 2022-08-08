package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counts {
     @Expose
     int cases;
     @Expose
     int suites;
     @Expose
     int milestones;
}
