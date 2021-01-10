package spring.controllers;


import org.springframework.web.bind.annotation.*;
import spring.dao.PeopleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import spring.models.Person;


@Controller
@RequestMapping("/people")
public class PeopleControllers {
    @Autowired
   private PeopleDAO peopleDAO;

    @GetMapping()
    public String index(Model model){
       model.addAttribute("people",peopleDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
       model.addAttribute("person", peopleDAO.getPerson(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPersonPage(Model model){
        model.addAttribute("person", new Person());// в случае th-форм

        return "people/new";
    }

//    @PostMapping
//    public String newPerson(@RequestParam("name")String name, Model model){
//        peopleDAO.save(new Person(0,name));
//        return "redirect:/people";
//    }
    @PostMapping
    public String newPerson(@ModelAttribute("person")Person person){
        peopleDAO.save(person);
        return "redirect:/people";
    }

}
