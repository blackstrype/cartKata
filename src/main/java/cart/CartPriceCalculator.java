package cart;

import cart.model.Cart;
import cart.model.Client;

public class CartPriceCalculator {

    public static final int UNIT_PRICE_PRO_ELITE_HIGH_END_TELEPHONE = 1000;
    public static final int UNIT_PRICE_PRO_ELITE_MIDDLE_END_TELEPHONE = 550;

    public static int calculateTotalPrice(Cart cart, Client client) {
        return cart.getHighEndTelephoneCount() * UNIT_PRICE_PRO_ELITE_HIGH_END_TELEPHONE
                + cart.getMiddleEndTelephoneCount() * UNIT_PRICE_PRO_ELITE_MIDDLE_END_TELEPHONE;
    }
}
