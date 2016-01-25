# Cucumber

[Cucumber](https://cucumber.io/) is a testing framework that gives product owners the ability to write their own unit tests. This technology utilizes a syntax called [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) which represents a form of behavior driven development that is easy to read and understand. Gherkin is a great method for documenting code in the case that your source files has limited documentation.

## Up and Running

Provided are a couple of build scripts. Consider using vagrant to simulate the tests on a system that has been shown to work.

```
cd counter/source

./build.sh  //creates *.class files
./run.sh    //runs the gherkin tests
```


