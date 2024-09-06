

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.junit.Assert;

public class CommandSteps {

    private String name;

    private Command command;

    @Given("Customer who wants to command for Someone : {string}")
    public void customerWhoWantsToCommandForSomeone(String name){
        command = new Command();
        command.setFrom(name);
    }

    @When("a Command is made for Someone")
    public void aCommandIsMadeForSomeone(){
        command.setTo("Tata");
    }

    @Then("there is no product in Command")
    public void thereIsNoProductInTheCommand(){
        Assert.assertTrue(command.getProducts().isEmpty());
    }

    @And("the command come from Customer")
    public void theCommandComeFromCustomer(){
        Assert.assertEquals("Titi",command.getFrom());
    }

}
