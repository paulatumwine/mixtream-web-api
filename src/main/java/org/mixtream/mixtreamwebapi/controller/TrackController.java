package org.mixtream.mixtreamwebapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.mixtream.mixtreamwebapi.dto.TrackDTO;
import org.mixtream.mixtreamwebapi.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("/track")
@RestController
public class TrackController {

    @Autowired
    TrackService service;

    @GetMapping("")
    public ResponseEntity<List<TrackDTO>> findAll() {
        log.info("find all");
        List<TrackDTO> obj = service.findAll();
        return obj == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDTO> findById(@NotNull @PathVariable String id) {
        log.info("find by id: {}", id);
        TrackDTO obj = service.findById(id);
        return Objects.isNull(obj.getId()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }

    @PostMapping("")
    public ResponseEntity<TrackDTO> create(@Valid @RequestBody TrackDTO obj) {
        log.info("create: {}", obj);
        return ResponseEntity.accepted().body(service.save(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackDTO> update(@NotNull @PathVariable String id, @Valid @RequestBody TrackDTO requestBody) {
        log.info("update: {}", requestBody);
        if (Objects.isNull(requestBody.getId())) {
            log.info("id missing, setting to: {}", id);
            requestBody.setId(id);
        } else if (!requestBody.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        TrackDTO responseBody = service.update(requestBody);
        return Objects.isNull(responseBody) ? ResponseEntity.notFound().build() : ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NotNull @PathVariable String id) {
        log.info("delete by id: {}", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
