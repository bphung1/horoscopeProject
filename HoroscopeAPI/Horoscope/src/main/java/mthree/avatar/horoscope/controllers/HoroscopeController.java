package mthree.avatar.horoscope.controllers;

import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import mthree.avatar.horoscope.service.HoroscopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HoroscopeController {
    @Autowired
    private HoroscopeService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public User createAccount(@RequestBody User user) {
        return service.createAccount(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/generate")
    public void generateHoroscope(@RequestBody User user) {
        //return service.generateHoroscope(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{username}")
    public List<Prediction> getAllHoroscopes(@PathVariable String username) {
        return service.getAllHoroscopes(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{id}")
    public User updateUserInfo(@RequestBody User user) {
        return service.updateUserInfo(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public boolean deleteHoroscope(@RequestBody Prediction prediction) {
        return service.deleteHoroscope(prediction);
    }
}
