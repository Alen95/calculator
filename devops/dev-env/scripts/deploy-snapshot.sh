#!/bin/bash


# Define Tomcat's variables
APACHE_HOME=/opt/tomcat
APACHE_BIN=$APACHE_HOME/bin
APACHE_WEBAPPS=$APACHE_HOME/webapps

# Define product's variables
PRODUCT_SNAPSHOT_NAME=calculator-1.0-SNAPSHOT.war
RESOURCE_NAME=calculator.war


# Shutdown Tomcat
sh $APACHE_BIN/shutdown.sh && sleep 15


# Deploy generated SNAPSHOT into the dev-env  
sudo [ -f $APACHE_WEBAPPS/$RESOURCE_NAME ] && sudo rm $APACHE_WEBAPPS/$RESOURCE_NAME 
cp /vagrant_target/$PRODUCT_SNAPSHOT_NAME $APACHE_WEBAPPS
cd $APACHE_WEBAPPS
mv $PRODUCT_SNAPSHOT_NAME $RESOURCE_NAME
chown tomcat:tomcat $RESOURCE_NAME


# Start up Tomcat
sh $APACHE_BIN/startup.sh