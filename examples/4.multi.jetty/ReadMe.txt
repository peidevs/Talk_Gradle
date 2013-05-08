
This example is functionally the same as 5b.

The differene is that the common, pojo, and web packages are moved into their own projects.

There is a build.gradle file at the root, and one in each directory. Note the usage of 
the task paths for dependencies and such. e.g. dependsOn(":common")

5b doc:

This example adds the Jetty plugin so that the servlet can be tested in an embedded web server.

It builds the war, deploys to Jetty, and uses some code to hit a URL to prove data was loaded into the memory DB.

*** Usage 

gradle clean
gradle runWarTest   # this will call assemble, check, war, etc

OR 

gradle --gui &
select the target from the big list (all provided by the Java plugin)
