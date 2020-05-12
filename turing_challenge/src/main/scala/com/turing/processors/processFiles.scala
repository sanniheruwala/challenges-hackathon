package com.turing.processors

import java.io.File
import java.nio.file.{FileSystems, Files}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path


import scala.collection.JavaConverters.asScalaIteratorConverter
import scala.util.Try

/**
  * @author sheruwala on 2019-04-15.
  */
object processFiles {

  def getListOfFiles(f: String): List[String] = {
    val dir = FileSystems.getDefault.getPath(f)
    Files.walk(dir).iterator().asScala.filter(Files.isRegularFile(_)).map(_.toString).toList
  }

  def rename(oldName: String, replace: String) = {
    val newName = oldName.replaceAll(replace,"")
    Try(new File(oldName).renameTo(new File(newName))).getOrElse(false)
  }

  def hdfsRename(oldName:String, replace:String):Unit ={
    val hadoopConf = new Configuration()
    val hdfs = FileSystem.get(hadoopConf)

    val newName = oldName.replaceAll(replace,"")

    println(oldName)
    println(newName)
    val srcPath = new Path(oldName)
    val destPath = new Path(newName)

    hdfs.moveFromLocalFile(srcPath, destPath)
  }
}
