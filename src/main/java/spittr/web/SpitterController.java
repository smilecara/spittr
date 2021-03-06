package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
	  model.addAttribute(new Spitter());
	  return "registerForm";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @RequestPart ("profilePicture") MultipartFile profilePicture,
      @Valid Spitter spitter, 
      Errors  errors) throws IllegalStateException, IOException {
    if (errors.hasErrors()) {
      return "registerForm";
    }
    profilePicture.transferTo(new File("/data/spittr/"+profilePicture.getOriginalFilename()));
    spitterRepository.save(spitter);
    return "redirect:/spitter/" + spitter.getUserName();
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUserName(username);
    model.addAttribute(spitter);
    return "profile";
  }
  
}
