package spring.controllers;

import spring.dao.PeopleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/people")
public class PeopleControllers {
    @Autowired
   private PeopleDAO peopleDAO;

    @GetMapping()
    public String index(Model model){
       model.addAttribute("people",peopleDAO.index());
        System.out.println("fdsfsdf");
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
       model.addAttribute("person", peopleDAO.getPerson(id));
        return "people/show";
    }

}
