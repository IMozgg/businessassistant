package io.khasang.ba.controller;

import io.khasang.ba.service.MyService;
import io.khasang.ba.service.MySqlOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    @Qualifier("second")
    private MyService myService;    //  DI Message from interface MyService - it good!

    @Autowired
    private MySqlOperation createTable;

    //private Message msg; // DI Message from class @Component

    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", myService.getName());
        return "home";
    }

    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "helloName";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/create")
    public String createTable(Model model) {
        model.addAttribute("status", createTable.getTableCreationStatus());
        return "sqlStatus";
    }

    @RequestMapping("/insert")
    public String insertData(Model model) {
        model.addAttribute("status", createTable.getTableInsertStatus());
        return "sqlStatus";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getCryptPassword(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @RequestMapping("/doginfo")
    public String getHelloPage() {
        return "dog";
    }
}
