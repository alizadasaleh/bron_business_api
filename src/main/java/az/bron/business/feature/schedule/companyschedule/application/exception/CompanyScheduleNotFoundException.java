package az.bron.business.feature.schedule.companyschedule.application.exception;

import az.gov.dlp.exception.NotFoundException;
import az.gov.dlp.exception.model.ErrorDetails;

public class CompanyScheduleNotFoundException extends NotFoundException {
    public CompanyScheduleNotFoundException() {
        super(ErrorDetails.of("", "CompanySchedule not found",
                "",
                ErrorDetails.error(314_00, "CompanyScheduleNotFound")));
    }

    public CompanyScheduleNotFoundException(String s) {
        super(ErrorDetails.of("", "CompanySchedule not found",
                s,
                ErrorDetails.error(314_00, "CompanyScheduleNotFound")));
    }
}
