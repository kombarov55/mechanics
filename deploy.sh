#!/usr/bin/env bash

cd ~/IdeaProjects/tmp/mech;
mvn package;
scp target/car-parts-1.war root@server:/usr/local/apache-tomcat-8.5.31/webapps/car-parts.war;
ssh root@server /usr/local/apache-tomcat-8.5.31/bin/shutdown.sh
ssh root@server /usr/local/apache-tomcat-8.5.31/bin/startup.sh
