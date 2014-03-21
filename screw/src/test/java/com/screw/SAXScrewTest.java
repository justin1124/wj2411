package com.screw;

import org.junit.Test;

public class SAXScrewTest {

    @Test
    public void test() throws Exception{
        SAXScrew saxScrew = new SAXScrew();
        Order order = (Order) saxScrew.fromXML("thirdParty/order.xml");
        System.out.println(order.getId());
        System.out.println(order.getAddress());
    }
}
