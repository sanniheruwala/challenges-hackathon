package com.turing.commons

import scala.io.Source

/**
  * @author sheruwala on 2019-04-15.
  */
object utils {

  def getContent(url: String): String = {

    val data: String = Source.fromURL(url).mkString
    data
  }

}
