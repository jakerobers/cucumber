# javac -cp "/usr/local/share/jars/*:/usr/share/java/*:./counter_test/*:./counter_ui/*" step_definitions/GuiStepDefinitions.java

find -name "*.java" > sources.txt
javac -cp "/usr/local/share/jars/*:/usr/share/java/*" @sources.txt

