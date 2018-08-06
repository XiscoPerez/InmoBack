package mx.com.realstate.administration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class SwaggerController.
 *
 * @author FPLOPEZ Francisco Perez Lopez
 */
@Controller
public final class SwaggerController {

  /**
   * Index.
   *
   * @return the string
   */
  @RequestMapping(value = "/")
  public String index() {
    return "redirect:swagger-ui.html";
  }
}
