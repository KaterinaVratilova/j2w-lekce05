package cz.czechitas.java2webapps.lekce5.people;

import cz.czechitas.java2webapps.lekce5.entity.Gender;
import cz.czechitas.java2webapps.lekce5.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

/**
 * @author Filip Jirsák
 */
@Controller
public class FamousPeopleController {
  private final FamousPeopleService service;

  public FamousPeopleController(FamousPeopleService service) {
    this.service = service;
  }

  @GetMapping("/")
  public ModelAndView list() {
    ModelAndView result = new ModelAndView("index");
    result.addObject("people", service.getAll());
    result.addObject("gender", Gender.values());
    return result;
  }

}
