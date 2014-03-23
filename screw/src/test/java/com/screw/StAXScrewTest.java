package com.screw;

import java.io.InputStream;

import org.junit.Test;

import com.screw.common.utils.StringUtils;

public class StAXScrewTest {

    @Test
    public void test() throws Exception{
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("thirdParty/order.xml");
        String xml = StringUtils.convertStreamToString(input);
        Screw saxScrew = new StAXScrew();
        Order order = saxScrew.fromXML(xml, Order.class);
        System.out.println("==============================");
        System.out.println(order.getId());
        System.out.println(order.getPrice());
        System.out.println(order.getAddress());
    }
}
