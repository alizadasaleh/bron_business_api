package az.bron.business.feature.review.domain.model;

import az.bron.business.feature.appointment.domain.model.Appointment;
import az.bron.business.feature.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float rating;

    private String comment;

    @ManyToOne
    private Appointment appointment;

    @ManyToOne
    private User user;

}
