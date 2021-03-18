package org.mixtream.mixtreamwebapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.AlbumDTO;
import org.mixtream.mixtreamwebapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("/album")
@RestController
public class AlbumController {

    @Autowired
    AlbumService service;

    @GetMapping("")
    public ResponseEntity<List<AlbumDTO>> findAll() {
        log.info("find all");
        List<AlbumDTO> obj = service.findAll();
        return obj == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> findById(@NotNull @PathVariable Integer id) {
        log.info("find by id: {}", id);
        AlbumDTO obj = service.findById(id);
        return Objects.isNull(obj.getId()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @PostMapping("")
    public ResponseEntity<AlbumDTO> create(@Valid AlbumDTO obj) {
        log.info("create: {}", obj);
        return ResponseEntity.accepted().body(service.save(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> update(@NotNull @PathVariable Integer id, @Valid @RequestBody AlbumDTO requestBody) {
        log.info("update: {}", requestBody);
        if (Objects.isNull(requestBody.getId())) {
            log.info("id missing, setting to: {}", id);
            requestBody.setId(id);
        } else if (!requestBody.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        AlbumDTO responseBody = service.update(requestBody);
        return Objects.isNull(responseBody) ? ResponseEntity.notFound().build() : ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NotNull @PathVariable Integer id) {
        log.info("delete by id: {}", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
