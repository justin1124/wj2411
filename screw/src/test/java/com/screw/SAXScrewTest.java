package com.screw;

import java.io.InputStream;

import org.junit.Test;

public class SAXScrewTest {

    @Test
    public void test() throws Exception{
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("thirdParty/books.xml");
        SAXScrew saxScrew = new SAXScrew();
        saxScrew.getBooks(input);
    }
}
