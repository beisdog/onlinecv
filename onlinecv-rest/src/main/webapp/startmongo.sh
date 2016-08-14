#!/bin/bash

MONGO_LOG=/home/user/mongodb.log


function wait_mongodb_ready_to_connect {
    # Execute mongod service
    mkdir -p /home/user/mongodb/db
    /usr/bin/mongod --dbpath /home/user/mongodb/db --port 27017 --smallfiles --httpinterface --rest --fork --logpath /home/user/mongo.log > /dev/null

    # Wait until mongo logs that it's ready (or timeout after 60s)
    COUNTER=0
    ps -ef
    $MONGO_LOG

    while [[ $? -ne 0 && $COUNTER -lt 60 ]] ; do
        sleep 2
        let COUNTER+=2
	grep -q 'waiting for connections on port' $MONGO_LOG
    done

    if [ $? -eq 0 ] ; then
     echo "mongo started"
    else
		echo "Failed to start MongoDB. Timeout limit exceedpwded."
		show_mongodb_logs
    fi
}



function show_mongodb_logs {
    if [ -e $MONGO_LOG ] ; then
        echo "MongoDB logs:"
        cat $MONGO_LOG
    fi
}

wait_mongodb_ready_to_connect

# keep docker container running after stopping of apllication
sleep 365d