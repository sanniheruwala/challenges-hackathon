package com.turing.exe

import com.turing.processors.processFiles._
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.StringType

/**
  * @author SHeruwala on 2019-04-09.
  */

object runWorkflow extends SparkConfig {

  def main(args: Array[String]): Unit = {

    //    val data = utils.getContent("https://raw.githubusercontent.com/monikturing/turing-data-challenge/master/url_list.csv").split("\n").toList
    //    val urls = data.filter(_.contains("https://"))
    //    val rdd = spark.sparkContext.parallelize(urls)

    //    val cloned: RDD[Boolean] = rdd.map(x => gitProcess.clone(x , x.split("/").last+"_"+System.currentTimeMillis()))

    //    cloned.count()

    val files =
    //      .getListOfFiles("/Users/sheruwala/Downloads/recpy_1555326719747/")
      getListOfFiles("/Users/sheruwala/Documents/Personal/turing_dataset/Notes_1555330993811/")
        .filter(x => x.toString.endsWith(".py"))

    val underscoreFileRename = files.filter(_.toString.startsWith("_")).map(x => hdfsRename(x.toString,"_"))
    val colonFileRename = files.filter(_.toString.contains(":")).map(x => hdfsRename(x.toString,":"))

    val pythonFiles =
    //      .getListOfFiles("/Users/sheruwala/Downloads/recpy_1555326719747/")
      getListOfFiles("/Users/sheruwala/Documents/Personal/turing_dataset/Notes_1555330993811/")
        .filter(x => x.endsWith(".py"))

    println(pythonFiles)

    def emptyToNull(c: Column) = when(length(trim(c)) > 0, c)

//    val data = spark.sparkContext.textFile(pythonFiles.mkString(","), 1).zipWithIndex()
//
//    import spark.implicits._
//    val df = data.toDF("code", "index")
//      .withColumn("code", trim(emptyToNull(col("code"))))
//      .withColumn("fileName", reverse(split(reverse(input_file_name().cast(StringType)), "/")(0)))
//      .withColumn("projectName", split(input_file_name().cast(StringType), "/")(6))
//      .withColumn("dirPath", input_file_name())
//
//    val removeHashComments = df.filter(!col("code").startsWith(lit("#")))
//
//    val indexOfSingleQuote = df.filter(col("code") === lit("'''")).select("index").collect().map(_.getLong(0)).toList
//    val indexOfDoubleQuote = df.filter(col("code") === lit("\"\"\"")).select("index").collect().map(_.getLong(0)).toList

//    println(removeHashComments.count + "##########")


  }
}
