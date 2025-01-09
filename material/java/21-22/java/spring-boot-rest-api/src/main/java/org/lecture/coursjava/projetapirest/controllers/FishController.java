package org.lecture.coursjava.projetapirest.controllers;

import java.util.concurrent.ThreadLocalRandom;

import org.lecture.coursjava.projetapirest.models.Fish;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {

    @GetMapping("/random-fish")
    Fish getRandomFish() {
        var fish = new Fish();
        fish.setId(ThreadLocalRandom.current().nextInt(0, 11));
        fish.setWeight(ThreadLocalRandom.current().nextInt(10, 30));
        fish.setName("Banana");
        return fish;
    }

}
