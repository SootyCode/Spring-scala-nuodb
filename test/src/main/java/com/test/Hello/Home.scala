package com.test.Hello

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import java.lang.String
import org.springframework.ui.ModelMap
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource
import org.springframework.transaction.annotation.Transactional
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 25/05/13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(Array("/hello"))
class Home {
  private val logger = LoggerFactory.getLogger(this.getClass)

  private var jdbcTemplate: JdbcTemplate = _

  @Autowired
  private var dataSource: DataSource = _


  @Transactional
  @RequestMapping(method = Array(RequestMethod.GET)) def printWelcome(model: ModelMap): String = {
    model.addAttribute("message", "Hello world!")
    logger.info("hello")
    //
    //    jdbcTemplate.execute("CREATE SCHEMA test")
    //    jdbcTemplate.execute("CREATE TABLE test.test (email string, name string)")
    //    jdbcTemplate.update("insert into test.test (email, name) values (?, ?)", x.getEmail, x.getFirstname +" "+ x.getLastname)

    val list: List[java.util.Map[String, Object]] = jdbcTemplate.queryForList("select * from test.test").asScala.toList
    model.addAttribute(list)
    "hello"
  }

  def setDataSource(dataSource: DataSource) {
    this.dataSource = dataSource
    this.jdbcTemplate = new JdbcTemplate(dataSource)
  }
}
