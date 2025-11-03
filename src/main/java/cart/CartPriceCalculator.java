package cart;

import cart.model.Cart;
import cart.model.Client;

public class CartPriceCalculator {
    public static int calculateTotalPrice(Cart cart, Client client) {
        return cart.getHighEndTelephoneCount() * 1000 + cart.getMiddleEndTelephoneCount() * 550;
    }
}
