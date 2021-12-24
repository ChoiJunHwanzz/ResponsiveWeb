package com.example.backend.controller;


import com.example.backend.entity.Gongzi;
import com.example.backend.request.GongziRequest;
import com.example.backend.service.GongziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gongzi")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class GongziController {
    @Autowired
    private GongziService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody GongziRequest request) throws Exception {

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Gongzi>> list() throws Exception {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{gongziNo}")
    public ResponseEntity<Gongzi> read(@PathVariable("gongziNo") Long gongziNo) throws Exception {
        Gongzi gongzi = service.read(gongziNo);

        return new ResponseEntity<>(gongzi, HttpStatus.OK);
    }

    @DeleteMapping("/{gongziNo}")
    public ResponseEntity<Void> remove(@PathVariable("gongziNo") Long gongziNo) throws Exception {
        service.remove(gongziNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PatchMapping("/{gongziNo}")
    public ResponseEntity<Void> update(@PathVariable("gongziNo") Long gongziNo,
                                       @RequestBody GongziRequest request) throws Exception {

        Gongzi gongzi = service.read(gongziNo);

        service.modify(gongzi, request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/{gongziNo}/{view}")
    public ResponseEntity<Integer> viewCount(@PathVariable("gongziNo") Long gongziNo,
                                             @PathVariable("view") Integer view) throws Exception {
        service.view(gongziNo, view);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
