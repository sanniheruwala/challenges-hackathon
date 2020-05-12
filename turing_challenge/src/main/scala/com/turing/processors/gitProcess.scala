package com.turing.processors

import java.io.File

import org.eclipse.jgit.api.Git

/**
  * @author sheruwala on 2019-04-15.
  */
object gitProcess {

  def clone(url: String, fileName: String): Boolean = {
    try {
      Git
        .cloneRepository()
        .setURI(url)
        .setDirectory(new File(s"/Users/sheruwala/Documents/Personal/turing_dataset/$fileName"))
        .call()

      println(s"$fileName cloned successfully.")
      true
    }
    catch {
      case ex: Exception => println(ex.printStackTrace())
        false
    }
  }

}
