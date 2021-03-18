package org.mixtream.mixtreamwebapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.UserDTO;
import org.mixtream.mixtreamwebapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        log.info("find all");
        List<UserDTO> obj = service.findAll();
        return obj == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@NotNull @PathVariable String id) {
        log.info("find by id: {}", id);
        UserDTO obj = service.findById(id);
        return Objects.isNull(obj.getId()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO obj) {
        log.info("create: {}", obj);
        return ResponseEntity.accepted().body(service.save(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@NotNull @PathVariable String id, @Valid @RequestBody UserDTO requestBody) {
        log.info("update: {}", requestBody);
        if (Objects.isNull(requestBody.getId())) {
            log.info("id missing, setting to: {}", id);
            requestBody.setId(id);
        } else if (!requestBody.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO responseBody = service.update(requestBody);
        return Objects.isNull(responseBody) ? ResponseEntity.notFound().build() : ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NotNull @PathVariable String id) {
        log.info("delete by id: {}", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
