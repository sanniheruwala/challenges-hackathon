package com.turing.exe

import org.apache.spark.sql.SparkSession

/**
  * Created by SHeruwala on 7/18/2018.
  */
trait SparkConfig {

  /**
    * Spark session provided.
    */
  implicit val spark: SparkSession = SparkSession
    .builder()
    .appName("Turing Solution")
    .master("local[*]")
    .getOrCreate()

}
