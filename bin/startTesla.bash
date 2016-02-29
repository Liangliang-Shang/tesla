#!/bin/env bash
APPHOME=/home/lshang/devel/tesla
export APPHOME

CLASSPATH=.:$APPHOME/lib/quickfixj-all-1.6.0.jar
CLASSPATH=$CLASSPATH:$APPHOME/lib/slf4j-api-1.7.12.jar
CLASSPATH=$CLASSPATH:$APPHOME/lib/slf4j-jdk14-1.7.12.jar
CLASSPATH=$CLASSPATH:$APPHOME/lib/mina-core-2.0.9.jar
CLASSPATH=$CLASSPATH:$APPHOME/lib/tesla.jar
export CLASSPATH
