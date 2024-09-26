package az.bron.business.feature.schedule.common.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;
import lombok.Data;

@Data
public class Schedule {
    @Schema(description = "Work hours per day",
            example = "{\"MONDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"TUESDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"WEDNESDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"THURSDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"FRIDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"SATURDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]},"
                    + "\"SUNDAY\":{\"startTime\":\"09:00\",\"endTime\":\"18:00\",\"breaks\":["
                    + "{\"breakStartTime\":\"13:00\",\"breakEndTime\":\"14:00\"}]}}")
    private Map<Workday, WorkingHours> schedule;

}

