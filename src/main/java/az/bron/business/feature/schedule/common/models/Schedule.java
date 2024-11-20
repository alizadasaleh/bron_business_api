package az.bron.business.feature.schedule.common.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;
import lombok.Data;

@Data
@Schema(description = "Work hours per day",
        example = "{\"monday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"tuesday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"wednesday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"thursday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"friday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"saturday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                + "\"sunday\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]}}")
public class Schedule {

    private WorkingHours monday;
    private WorkingHours tuesday;
    private WorkingHours wednesday;
    private WorkingHours thursday;
    private WorkingHours friday;
    private WorkingHours saturday;
    private WorkingHours sunday;

}

