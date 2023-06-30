package net.internalerror.appyserver.web;

import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.repository.AuthTokenRepository;
import net.internalerror.appyserver.data.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class WebController {

  private final UserRepository userRepository;
  private final AuthTokenRepository authTokenRepository;

  @GetMapping("/api/user")
  public String getAllUsers(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "users";
  }

  @GetMapping("/api/user/delete/{id}")
  public String deleteUser(@PathVariable("id") long id, Model model) {
    userRepository.deleteById(id);
    return getAllUsers(model);
  }


  @GetMapping("/api/authToken")
  public String getAllAuthTokens(Model model) {
    model.addAttribute("authTokens", authTokenRepository.findAll());
    return "authTokens";
  }

  @GetMapping("/api/authToken/delete/{id}")
  public String deleteAuthToken(@PathVariable("id") long id, Model model) {
    authTokenRepository.deleteById(id);
    return getAllUsers(model);
  }
}
