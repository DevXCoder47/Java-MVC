package com.nikijv.javamvc.controller;

import com.nikijv.javamvc.dto.AddressBookDto;
import com.nikijv.javamvc.model.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AddressBookController {
    List<AddressBook> books = new ArrayList<>(List.of(
            new AddressBook("N1", "324234", "E1", "BR1", "No1"),
            new AddressBook("N2", "734342", "E2", "BR2", "No1"),
            new AddressBook("N2", "854234", "E3", "BR3", "No2"),
            new AddressBook("N2", "465754", "E4", "BR4", "No2"),
            new AddressBook("N3", "234675", "E5", "BR5", "No3")
    ));
    List<AddressBookDto> dtos = new ArrayList<>(List.of(
            new AddressBookDto("N1", "E1", "BR1"),
            new AddressBookDto("N2", "E2", "BR2"),
            new AddressBookDto("N2", "E3", "BR3"),
            new AddressBookDto("N2", "E4", "BR4"),
            new AddressBookDto("N3", "E5", "BR5")
    ));

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("books", dtos);
        return "home";
    }

    @GetMapping("/addEntry")
    public String add() {
        return "add";
    }

    @PostMapping("/select")
    public String select(@RequestParam("bookCred") String bookCred, Model model) {
        AddressBook selectedBook = books.stream()
                .filter(b -> b.getCredentials().equals(bookCred))
                .findFirst()
                .orElse(null);
        model.addAttribute("book", selectedBook);
        return "selected";
    }

    @PostMapping("/addToList")
    public String add(@RequestParam("cred") String cred
    , @RequestParam("phone") String phone
    , @RequestParam("email") String email
    , @RequestParam("blog") String blog
    , @RequestParam("notes") String notes) {
        books.add(new AddressBook(cred, phone, email, blog, notes));
        dtos.add(new AddressBookDto(cred, email, blog));
        return "redirect:/home";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("bookCred") String bookCred, Model model) {
        AddressBook selectedBook = books.stream()
                .filter(b -> b.getCredentials().equals(bookCred))
                .findFirst()
                .orElse(null);

        if(selectedBook != null) {
            books.remove(selectedBook);
        }

        dtos.stream()
                .filter(b -> b.getCredentials().equals(bookCred))
                .findFirst().ifPresent(selectedDto -> dtos.remove(selectedDto));

        model.addAttribute("book", selectedBook);
        return "edited";
    }

    @PostMapping("/editToList")
    public String edit(@RequestParam("cred") String cred
            , @RequestParam("phone") String phone
            , @RequestParam("email") String email
            , @RequestParam("blog") String blog
            , @RequestParam("notes") String notes) {
        books.add(new AddressBook(cred, phone, email, blog, notes));
        dtos.add(new AddressBookDto(cred, email, blog));
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("bookCred") String bookCred) {
        books.stream()
                .filter(b -> b.getCredentials().equals(bookCred))
                .findFirst()
                .ifPresent(selectedBook -> books.remove(selectedBook));

        dtos.stream()
                .filter(b -> b.getCredentials().equals(bookCred))
                .findFirst().ifPresent(selectedDto -> dtos.remove(selectedDto));

        return "redirect:/home";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam("bookCred") String bookCred, Model model) {
        List<AddressBookDto> filteredDtos = dtos.stream()
                .filter(d -> d.getCredentials().equals(bookCred))
                .toList();
        model.addAttribute("books", filteredDtos);
        return "home";
    }
}
