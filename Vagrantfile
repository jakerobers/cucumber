# -*- mode: ruby -*-
# vi: set ft=ruby :

#
# Vagrant configuration for Exercise 6, SE 3800
# Author: Robert W. Hasker
#
# This installs Ubuntu 14.04, and basic libraries for bare-bones Cucumber
#

Vagrant.configure(2) do |config|
config.vm.box = "ubuntu/trusty32"

config.vm.provider :virtualbox do |vb|
# Uncomment following to help diagnose problems when vagrant up fails
vb.gui = true
end

# Forward ports for Jenkins
#config.vm.network "forwarded_port", guest: 6060, host: 6060
#config.vm.network "forwarded_port", guest: 8080, host: 7070
# 
# This allows accessing Jenkins as http://localhost:7070/
# see: https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+on+Ubuntu
#

# install packages and jar files for Cucumber
config.vm.provision "shell", inline: <<-SHELL
sudo apt-get update
sudo apt-get install -y default-jdk
sudo apt-get install -y junit4
sudo apt-get install -y git
sudo apt-get install -y maven2
cd /usr/local/share
sudo mkdir -p jars
cd jars
# core required for all languages
sudo wget -nc http://repo1.maven.org/maven2/info/cukes/cucumber-core/1.2.4/cucumber-core-1.2.4.jar
# java-specific bindings
sudo wget -nc http://repo1.maven.org/maven2/info/cukes/cucumber-java/1.2.4/cucumber-java-1.2.4.jar
# additional java-specific bindings
sudo wget -nc http://repo1.maven.org/maven2/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.jar
# generic gherkin parser
sudo wget -nc http://repo1.maven.org/maven2/info/cukes/gherkin/2.12.2/gherkin-2.12.2.jar  
# java-specific bindings for gherkin
sudo wget -nc http://repo1.maven.org/maven2/info/cukes/gherkin-jvm-deps/1.0.3/gherkin-jvm-deps-1.0.3.jar
cd /usr/local/bin
sudo wget -nc https://faculty-web.msoe.edu/hasker/se3800/ex/6/ex6-cucumber
sudo chmod a+x ex6-cucumber
SHELL
end
