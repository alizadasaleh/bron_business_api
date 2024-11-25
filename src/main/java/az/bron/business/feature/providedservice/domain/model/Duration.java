package az.bron.business.feature.providedservice.domain.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Data
@Embeddable
public class Duration implements Serializable {
    private Integer hours;
    private Integer minutes;

    public static Duration of(Integer hours, Integer minutes) {
        Duration duration = new Duration();
        duration.hours = hours;
        duration.minutes = minutes;
        return duration;
    }

    public Duration plus(Duration duration) {
        return Duration.of(this.hours + duration.hours, this.minutes + duration.minutes);
    }

    public Duration minus(Duration duration) {
        return Duration.of(this.hours, this.minutes - duration.minutes);
    }

    public Duration plus(Integer hours, Integer minutes) {
        return Duration.of(this.hours, this.minutes + hours);
    }

    public Integer toMinutes(){
        return this.hours * 60 + this.minutes;
    }
}
