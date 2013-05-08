
This example adds the Jetty plugin so that the servlet can be tested in an embedded web server.

It builds the war, deploys to Jetty, and uses some code to hit a URL to prove data was loaded into the memory DB.

*** Usage 

1. gradle clean jettyRunWar  # browse to http://localhost:8088/music/MusicServ
or 
2. gradle clean runWarTest   # this will call assemble, check, war, etc

OR 

gradle --gui &
select the target from the big list (all provided by the Java plugin)
