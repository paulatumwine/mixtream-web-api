package org.mixtream.mixtreamwebapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.PlaylistDTO;
import org.mixtream.mixtreamwebapi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("/playlist")
@RestController
public class PlaylistController {

    @Autowired
    PlaylistService service;

    @GetMapping("")
    public ResponseEntity<List<PlaylistDTO>> findAll() {
        log.info("find all");
        List<PlaylistDTO> obj = service.findAll();
        return obj == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDTO> findById(@NotNull @PathVariable String id) {
        log.info("find by id: {}", id);
        PlaylistDTO obj = service.findById(id);
        return Objects.isNull(obj.getId()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @PostMapping("")
    public ResponseEntity<PlaylistDTO> create(@Valid @RequestBody PlaylistDTO obj) {
        log.info("create: {}", obj);
        return ResponseEntity.accepted().body(service.save(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistDTO> update(@NotNull @PathVariable String id, @Valid @RequestBody PlaylistDTO requestBody) {
        log.info("update: {}", requestBody);
        if (Objects.isNull(requestBody.getId())) {
            log.info("id missing, setting to: {}", id);
            requestBody.setId(id);
        } else if (!requestBody.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        PlaylistDTO responseBody = service.update(requestBody);
        return Objects.isNull(responseBody) ? ResponseEntity.notFound().build() : ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NotNull @PathVariable String id) {
        log.info("delete by id: {}", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
