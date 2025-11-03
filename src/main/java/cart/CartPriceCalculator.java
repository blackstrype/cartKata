package cart;

import cart.model.Cart;
import cart.model.Client;

public class CartPriceCalculator {

    public static final int UNIT_PRICE_PRO_ELITE_HIGH_END_TELEPHONE = 1000;
    public static final int UNIT_PRICE_PRO_ELITE_MIDDLE_END_TELEPHONE = 550;
    private static final int UNIT_PRICE_PRO_ELITE_LAPTOP = 900;
    private static final int UNIT_PRICE_PRO_HIGH_END_TELEPHONE = 1150;
    private static final int UNIT_PRICE_PRO_MIDDLE_END_TELEPHONE = 600;
    private static final int UNIT_PRICE_PRO_LAPTOP = 1000;

    public static int calculateTotalPrice(Cart cart, Client client) {
        if (client.getTurnover() > 10000000) {
            return cart.getHighEndTelephoneCount() * UNIT_PRICE_PRO_ELITE_HIGH_END_TELEPHONE
                    + cart.getMiddleEndTelephoneCount() * UNIT_PRICE_PRO_ELITE_MIDDLE_END_TELEPHONE
                    + cart.getLaptopCount() * UNIT_PRICE_PRO_ELITE_LAPTOP;
        } else {
            return cart.getHighEndTelephoneCount() * UNIT_PRICE_PRO_HIGH_END_TELEPHONE
                    + cart.getMiddleEndTelephoneCount() * UNIT_PRICE_PRO_MIDDLE_END_TELEPHONE
                    + cart.getLaptopCount() * UNIT_PRICE_PRO_LAPTOP;
        }
    }
}
