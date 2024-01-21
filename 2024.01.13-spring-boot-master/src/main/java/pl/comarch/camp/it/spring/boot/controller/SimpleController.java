package pl.comarch.camp.it.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.comarch.camp.it.spring.boot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SimpleController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("O kurde cos sie odpalilo i działa !!!");
        return "index";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("Jakas inna metoda !!");
        return "test2";
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam("imie") String name,
                        @RequestParam("nazwisko") String surname,
                        @RequestParam("wiek") int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "index";
    }

    @RequestMapping(path = "/test4/{id}/{name}/{surname}/{age}", method = RequestMethod.GET)
    public String test4(@PathVariable int id,
                        @PathVariable String name,
                        @PathVariable String surname,
                        @PathVariable int age) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "index";
    }

    @RequestMapping(path = "/test5/{id}/{name}")
    public String test5(@PathVariable int id,
                        @PathVariable String name,
                        @RequestParam String surname,
                        @RequestParam int age) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "index";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String formReceive(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "index";
    }

    @RequestMapping(path = "/test6", method = RequestMethod.GET)
    public String test6(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Janusz");
        names.add("Wiesiek");
        names.add("Mateusz");
        names.add("Zosia");
        names.add("Zbyszek");
        names.add("Jadzia");

        Random random = new Random();
        String randomName = names.get(random.nextInt(names.size()));

        model.addAttribute("name", randomName);
        model.addAttribute("imiona", names);

        return "names";
    }

    @RequestMapping(path = "/big-form", method = RequestMethod.GET)
    public String bigForm(Model model) {
        User user = new User();
        model.addAttribute("userObject", user);
        System.out.println(user);
        return "big-form";
    }

    @RequestMapping(path = "/big-form", method = RequestMethod.POST)
    public String bigForm2(@ModelAttribute User user) {
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getAge());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getPassword2());
        return "index";
    }
}
