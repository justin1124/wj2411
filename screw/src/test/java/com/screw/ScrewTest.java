package com.screw;

import java.io.InputStream;

import org.junit.Test;

import com.screw.common.utils.StringUtils;

public class ScrewTest {

    @Test
    public void testFromXML() throws Exception{
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("thirdParty/order.xml");
        String xml = StringUtils.convertStreamToString(input);
        Order order = Screw.fromXML(xml, Order.class);
        System.out.println(order.getId());
        System.out.println(order.getPrice());
        System.out.println(order.getWhere());
    }
}
