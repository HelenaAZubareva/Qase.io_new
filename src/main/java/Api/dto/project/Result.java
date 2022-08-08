package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.ArrayList;
@Data
public class Result {

    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    int count;
    @Expose
    ArrayList<Project> entities;
}

