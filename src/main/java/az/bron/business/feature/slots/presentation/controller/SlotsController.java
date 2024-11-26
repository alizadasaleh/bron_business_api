package az.bron.business.feature.slots.presentation.controller;

import az.bron.business.feature.slots.application.facade.SlotsFacade;
import az.bron.business.feature.slots.application.model.Slot;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/slots")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SlotsController {
    private final SlotsFacade slotsFacade;

    @GetMapping("/available")
    public ResponseEntity<List<Slot>> getAvailableSlots(
            @RequestParam @Min(1) Long staffId,
            @RequestParam @Min(1) Long serviceId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "Start date in the format: yyyy-MM-dd (e.g., 2024-11-24)", example = "2024-11-24")
            LocalDate date) {

        List<Slot> response = slotsFacade.getAvailableSlots(staffId, serviceId, date);

        return ResponseEntity.ok(response);
    }


}
