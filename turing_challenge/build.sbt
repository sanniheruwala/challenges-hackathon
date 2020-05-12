name := "Solution"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.3.0" ,
  "org.apache.spark" %% "spark-sql"  % "2.3.0" ,
  "org.eclipse.jgit" % "org.eclipse.jgit" % "5.3.0.201903130848-r",
  "org.apache.hadoop" % "hadoop-common" % "2.6.0",
  "org.apache.commons" % "commons-io" % "1.3.2",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.6.0"
)
