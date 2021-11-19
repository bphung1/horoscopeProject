package mthree.avatar.horoscope.controllers;

import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import mthree.avatar.horoscope.service.HoroscopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void login(@RequestBody User user) {
        throw new UnsupportedOperationException("Not supported yet.");
        // return service.login(user);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/logout")
//    public void logout() {
//
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/generate")
    public void generateHoroscope(@RequestBody User user) {
        throw new UnsupportedOperationException("Not supported yet.");
        // return service.generateHoroscope(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{username}")
    public void getAllHoroscopes(@PathVariable String username) {
        // return service.getAllHoroscopes(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{id}")
    public void updateUserInfo(@RequestBody User user) {
        throw new UnsupportedOperationException("Not supported yet.");
        // return service.updateUserInfO(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public void deleteHoroscope(@RequestBody Prediction prediction) {
        throw new UnsupportedOperationException("Not supported yet.");
        // return service.deleteHoroscope(prediction);
    }
}
