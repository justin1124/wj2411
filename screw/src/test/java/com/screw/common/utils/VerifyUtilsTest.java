package com.screw.common.utils;

import org.junit.Assert;
import org.junit.Test;

public class VerifyUtilsTest {

    @Test
    public void testIsEmpty() {
        String str = "\r\n\t\t";
        Assert.assertTrue(VerifyUtils.isEmpty(str));
        str = null;
        Assert.assertTrue(VerifyUtils.isEmpty(str));
    }
    
    @Test
    public void testIsFloat() {
    	Assert.assertEquals(VerifyUtils.isFloat("3f"), true);
    	Assert.assertEquals(VerifyUtils.isFloat("3.3f"), true);
    	Assert.assertEquals(VerifyUtils.isFloat("-.33f"), true);
    	Assert.assertEquals(VerifyUtils.isFloat("-33.00f"), true);
    	Assert.assertEquals(VerifyUtils.isFloat("-33.00"), false);
    	Assert.assertEquals(VerifyUtils.isFloat("ddfffe33"), false);
    }
    
    @Test
    public void testIsInteger() {
    	Assert.assertEquals(VerifyUtils.isInteger("30"), true);
    	Assert.assertEquals(VerifyUtils.isInteger("-30"), true);
    	Assert.assertEquals(VerifyUtils.isInteger("122312123121"), false);
    	Assert.assertEquals(VerifyUtils.isInteger("1223121sss1"), false);
    }
    
    @Test
    public void testIsLong() {
    	Assert.assertEquals(VerifyUtils.isLong("30"), false);
    	Assert.assertEquals(VerifyUtils.isLong("-30"), false);
    	Assert.assertEquals(VerifyUtils.isLong("122312123121"), true);
    	Assert.assertEquals(VerifyUtils.isLong("-122312123121"), true);
    	Assert.assertEquals(VerifyUtils.isLong("-122l"), true);
    	Assert.assertEquals(VerifyUtils.isLong("122L"), true);
    	Assert.assertEquals(VerifyUtils.isLong("1223121sss1"), false);
    }

	@Test
	public void testIsNumeric() {
		Assert.assertEquals(VerifyUtils.isNumeric("13422224343"), true);
		Assert.assertEquals(VerifyUtils.isNumeric(""), false);
		Assert.assertEquals(VerifyUtils.isNumeric("134"), true);
		Assert.assertEquals(VerifyUtils.isNumeric("-13433"), true);
		Assert.assertEquals(VerifyUtils.isNumeric("134dfdfsfdf"), false);
	}
	
	@Test
	public void testIsDouble() {
		Assert.assertEquals(VerifyUtils.isDouble("-30.2222"), true);
		Assert.assertEquals(VerifyUtils.isDouble("30.2222"), true);
		Assert.assertEquals(VerifyUtils.isDouble("30"), false);
		Assert.assertEquals(VerifyUtils.isDouble("30ss"), false);
		Assert.assertEquals(VerifyUtils.isDouble(""), false);
		Assert.assertEquals(VerifyUtils.isDouble(".33"), true);
		Assert.assertEquals(VerifyUtils.isDouble("33."), true);
	}
}
