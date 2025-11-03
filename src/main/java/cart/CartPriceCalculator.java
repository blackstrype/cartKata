package cart;

import cart.model.Cart;
import cart.model.Client;

public class CartPriceCalculator {
    public static int calculateTotalPrice(Cart cart, Client client) {
        if(cart.getHighEndTelephoneCount() > 0)
            return 1000;
        else {
            return 0;
        }
    }
}
