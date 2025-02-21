package com.al.vqvc.spring_tesinng_3al2425.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al.vqvc.spring_tesinng_3al2425.model.Manga;
import com.al.vqvc.spring_tesinng_3al2425.service.MangaService;

@RestController
@RequestMapping("/manga")
public class MangaController {

  // Injection de dépendances
  @Autowired
  MangaService mangaService;

  @GetMapping
  public List<Manga> getAll() {
    return mangaService.getAll();
  }

  @PostMapping
  public ResponseEntity<Void> addOne(@RequestBody Manga manga) {
    if (mangaService.addOne(manga)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().build();
  }
}
