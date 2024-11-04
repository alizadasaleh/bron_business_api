//package az.bron.business.feature.user.presentation.controller;
//
//import az.bron.business.feature.user.application.facade.UserFacade;
//import az.bron.business.feature.user.application.model.request.CreateUserRequest;
//import az.bron.business.feature.user.application.model.request.UpdateUserRequest;
//import az.bron.business.feature.user.application.model.response.CreateUserResponse;
//import az.bron.business.feature.user.application.model.response.GetUserResponse;
//import az.bron.business.feature.user.application.model.response.UpdateUserResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/Users")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class UserRestController {
//    private final UserFacade userFacade;
//
//    @GetMapping
//    public ResponseEntity<List<GetUserResponse>> getUser() {
//        var response = userFacade.getAll();
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GetUserResponse> get(@PathVariable("id") Long id) {
//        var response = userFacade.get(id);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
//        var response = userFacade.create(request);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UpdateUserResponse> update(@PathVariable("id") Long id, @RequestBody UpdateUserRequest request) {
//        var response = userFacade.update(id, request);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") Long id) {
//       userFacade.delete(id);
//    }
//}
