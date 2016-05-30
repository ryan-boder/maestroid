androidBuild

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

scalaVersion := "2.11.8"
minSdkVersion in Android := "23"

run <<= run in Android

// Copied from the Scaloid hello-scaloid-sbt template project
updateCheck in Android := {} // disable update check
proguardCache in Android ++= Seq("org.scaloid")
proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
  , "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
)

libraryDependencies += "org.scaloid" %% "scaloid" % "4.2"
