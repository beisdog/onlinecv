#
# Copyright (c) 2012-2015 Codenvy, S.A.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Codenvy, S.A. - initial API and implementation
#

FROM codenvy/jdk7_tomcat7

RUN sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10 && \ 
    echo 'deb http://downloads-distro.mongodb.org/repo/debian-sysvinit dist 10gen' | sudo tee /etc/apt/sources.list.d/mongodb.list && \ 
    sudo apt-get update && \ 
    sudo apt-get -y --no-install-recommends install adduser mongodb-org 

RUN mkdir -p /home/user/mongodb/db
#RUN /usr/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongodb.log > /dev/null
#RUN sudo /usr/bin/mongod --dbpath /home/user/mongodb/db --fork --port 27017 --smallfiles --httpinterface --rest --logpath /home/user/mongo.log



$debug?EXPOSE 8000:$
$debug?ENV CODENVY_APP_PORT_8000_DEBUG 8000:$
$debug?CMD ./catalina.sh jpda run 2>&1:$

ENV CODENVY_APP_BIND_DIR /home/user/tomcat7/webapps/ROOT
VOLUME ["/home/user/tomcat7/webapps/ROOT"]

#ADD ./src/webapp/startmongo.sh /home/user/startmongo.sh

#RUN sudo chmod +x /home/user/startmongo.sh

#EXPOSE 27017

#RUN sudo /home/user/startmongo.sh




