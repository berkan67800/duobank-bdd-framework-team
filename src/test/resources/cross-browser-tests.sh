#!/bin/sh
mvn verify -D className=CucumberRunner -D browser=chrome
mvn verify -D className=CucumberRunner -D browser=chromeHeadless
mvn verify -D className=CucumberRunner -D browser=firefox
mvn verify -D className=CucumberRunner -D browser=edge
