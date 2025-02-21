package com.al.vqvc.spring_tesinng_3al2425.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.al.vqvc.spring_tesinng_3al2425.model.Manga;

@Service
public class MangaService {
  static List<Manga> mangas = new ArrayList<>();

  public List<Manga> getAll() {
    return mangas;
  }

  public boolean addOne(Manga manga) {
    if (manga.getIsbn() == null || mangas.stream().anyMatch(m -> m.getIsbn().equals(manga.getIsbn()))) {
      throw new Exceptio
    }
    mangas.add(manga);
    return true;
  }

  public void removeAll() {
    mangas.clear();
  }
}
