package step_definitions;
import counter_ui.FrameSample;
import counter_ui.IntField;
import counter_test.TestUtils;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;

public class GuiStepDefinitions {

  FrameSample f;

  @Before
  public void newFrame() {
    this.f = new FrameSample();
  }

  @Given("^the current (\\w+) count is (\\d+)$")
    public void givenCount(String label, int count) throws Exception {
      this.doIncrement(label, count);
    }

  @When("^the (\\w+) button is pressed (\\d+) times$")
    public void whenPressed(String label, int count) throws Exception {
      this.doIncrement(label, count);
    }

  public void doIncrement(String label, int count) throws Exception {
    JButton b = (JButton)TestUtils.getChildNamed(this.f, label);
    for (int i = 0; i < count; i++) {
      b.doClick();
    }
  }

  @Then("^the (\\w+) should be (\\d+)$")
    public void thenCount(String label, int expectation) {
      int count = this.getCount(label);
      assertEquals(count, expectation);
    }

  public int getCount(String label) {
    IntField c = (IntField) TestUtils.getChildNamed(this.f, label);
    return c.intValue();
  }
}

