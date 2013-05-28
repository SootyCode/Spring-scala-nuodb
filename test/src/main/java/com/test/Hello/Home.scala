package com.test.Hello

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.stereotype.Controller
import java.lang.String
import org.springframework.ui.ModelMap
import org.slf4j.LoggerFactory
import org.nascency.model.User
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 25/05/13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(Array("/hello"))
class Home {
  private val logger = LoggerFactory.getLogger(this.getClass)

  @RequestMapping(method = Array(RequestMethod.GET)) def printWelcome(model: ModelMap): String = {
    model.addAttribute("message", "Hello world!")
    logger.info("hello")
    val x = new User("justin", "holmes", "jholmes", "test", "justin@nascency.co.uk", 1, true)
    "hello"
  }
}
