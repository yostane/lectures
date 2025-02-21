package com.al.vqvc.spring_tesinng_3al2425;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.al.vqvc.spring_tesinng_3al2425.model.Manga;
import com.al.vqvc.spring_tesinng_3al2425.service.MangaService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MangaControllerTests {
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private MangaService mangaService;

  @BeforeEach
  void setup() {
    mangaService.removeAll();
  }

  @Test
  public void testGetAll() {
    // https://www.baeldung.com/spring-rest-template-list
    ResponseEntity<Manga[]> response = restTemplate.getForEntity("/manga", Manga[].class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    Manga[] mangas = response.getBody();
    assertEquals(0, mangas.length);

    Manga manga = new Manga();
    manga.setIsbn("sdsfds");
    manga.setName("my hero academia");
    manga.setNbPages(40);
    restTemplate.postForEntity("/manga", manga, Void.class);

    response = restTemplate.getForEntity("/manga", Manga[].class);
    assertNotNull(response.getBody());
    assertEquals(1, response.getBody().length);
    Manga responseManga = (Manga) response.getBody()[0];
    org.assertj.core.api.Assertions.assertThat(responseManga.getIsbn()).isEqualTo(manga.getIsbn());
    assertEquals(manga.getIsbn(), responseManga.getIsbn());
  }

  @Test
  public void testCannotAddSameIsbnTwice() {
    // TODO
  }
}
