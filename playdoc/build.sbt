name := """playdoc"""
organization := "playdoc"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test,
  "org.docx4j" % "docx4j" % "3.3.5" from "http://central.maven.org/maven2/org/docx4j/docx4j/3.3.5/docx4j-3.3.5.jar",
  "org.docx4j" % "docx4j-ImportXHTML" % "3.3.4" from "http://central.maven.org/maven2/org/docx4j/docx4j-ImportXHTML/3.3.4/docx4j-ImportXHTML-3.3.4.jar",
  "org.docx4j" % "xhtmlrenderer" % "3.0.0" from "http://central.maven.org/maven2/org/docx4j/xhtmlrenderer/3.0.0/xhtmlrenderer-3.0.0.jar",
  "commons-io" % "commons-io" % "2.5" from "http://central.maven.org/maven2/commons-io/commons-io/2.5/commons-io-2.5.jar",
  "xalan" % "xalan" % "2.7.1" from "http://central.maven.org/maven2/xalan/xalan/2.7.1/xalan-2.7.1.jar",
  "com.sun.xml.bind" % "jaxb-impl" % "2.2.11" from "http://central.maven.org/maven2/com/sun/xml/bind/jaxb-impl/2.2.11/jaxb-impl-2.2.11.jar",
  "com.sun.xml.bind" % "jaxb-core" % "2.2.11" from "http://central.maven.org/maven2/com/sun/xml/bind/jaxb-core/2.2.11/jaxb-core-2.2.11.jar",
  "com.lowagie" % "itext" % "4.2.1" from "http://central.maven.org/maven2/com/lowagie/itext/4.2.1/itext-4.2.1.jar",
  "xalan" % "serializer" % "2.7.1" from "http://central.maven.org/maven2/xalan/serializer/2.7.1/serializer-2.7.1.jar"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "playdoc.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "playdoc.binders._"
