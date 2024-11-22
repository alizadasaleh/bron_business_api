//package az.bron.business.feature.role.presentation.controller;
//
//import az.bron.business.feature.role.application.facade.RoleFacade;
//import az.bron.business.feature.role.application.model.request.CreateRoleRequest;
//import az.bron.business.feature.role.application.model.request.UpdateRoleRequest;
//import az.bron.business.feature.role.application.model.response.CreateRoleResponse;
//import az.bron.business.feature.role.application.model.response.GetRoleResponse;
//import az.bron.business.feature.role.application.model.response.UpdateRoleResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/roles")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class RoleRestController {
//    private final RoleFacade roleFacade;
//
//    @GetMapping
//    public ResponseEntity<List<GetRoleResponse>> getRole() {
//        var response = roleFacade.getAll();
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GetRoleResponse> get(@PathVariable("id") Integer id) {
//        var response = roleFacade.get(id);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<CreateRoleResponse> create(@RequestBody CreateRoleRequest request) {
//        var response = roleFacade.create(request);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UpdateRoleResponse> update(@PathVariable("id") Integer id, @RequestBody UpdateRoleRequest
//    request) {
//        var response = roleFacade.update(id, request);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") Integer id) {
//       roleFacade.delete(id);
//    }
//}
