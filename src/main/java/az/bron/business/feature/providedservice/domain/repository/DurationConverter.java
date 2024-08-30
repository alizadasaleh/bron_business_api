//package az.bron.business.feature.providedservice.domain.repository;
//
//import az.bron.business.feature.providedservice.application.model.request.Duration;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//@Converter(autoApply = true)
//public class DurationConverter implements AttributeConverter<Duration, Long> {
//
//    @Override
//    public Long convertToDatabaseColumn(Duration duration) {
//        return duration != null ? duration.toMillis() : null;
//    }
//
//    @Override
//    public Duration convertToEntityAttribute(Long millis) {
//        return millis != null ? Duration.ofMillis(millis) : null;
//    }
//}
//
