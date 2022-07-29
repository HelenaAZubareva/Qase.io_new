package Api.dto.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counts {
     int cases;
     int suites;
     int milestones;
}
