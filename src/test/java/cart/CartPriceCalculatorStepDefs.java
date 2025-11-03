package cart;

import cart.model.Cart;
import cart.model.Client;
import cart.model.ClientType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartPriceCalculatorStepDefs {

    Client client;
    Cart cart;
    private int calculatedTotalPrice;

    @Given("the client is a Professional")
    public void theClientIsAProfessional() {
        this.client = new Client();
        this.client.setClientType(ClientType.PROFESSIONAL);
        this.client.setCompanyName("Test Company");
        this.client.setSIREN("123456789");
        this.client.setTVANumber("123456789");
        this.cart = new Cart();
    }

    @When("the Professional client's turnover is {int}")
    public void theProfessionalClientsTurnoverIsGreaterThanMillionInTurnover(int turnover) {
        this.client.setTurnover(turnover);
    }

    @And("there are {int} high-end telephones in the shopping cart")
    public void addHighEndTelephonesInTheShoppingCart(int highEndTelephones) {
        this.cart.setHighEndTelephoneCount(highEndTelephones);
    }

    @And("there are {int} middle-end telephones in the shopping cart")
    public void addMiddleEndTelephonesInTheShoppingCart(int middleEndTelephones) {
        this.cart.setMiddleEndTelephoneCount(middleEndTelephones);
    }

    @And("there are {int} laptops in the shopping cart")
    public void addLaptopsInTheShoppingCart(int laptops) {
        this.cart.setLaptopCount(laptops);
    }

    @When("the price of the cart is calculated")
    public void thePriceOfTheCartIsCalculated() {
        this.calculatedTotalPrice = CartPriceCalculator.calculateTotalPrice(cart, client);
    }

    @Then("the total price of their cart will be {int} euros")
    public void theTotalCalculatedPriceOfTheirCartWillBeTheExpectedTotal(int total) {
        Assertions.assertEquals(total, this.calculatedTotalPrice);
    }

}