package designPattern.chainOfResp;

import designPattern.chainOfResp.handler.PriceHandler;
import designPattern.chainOfResp.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * 客户请求折扣
 */
public class Customer {
    private PriceHandler priceHandler;

    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ":");
            customer.requestDiscount(rand.nextFloat());
        }
    }

    private void setPriceHandler(PriceHandler priceHandler){
        this.priceHandler = priceHandler;
    }

    private void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }
}
