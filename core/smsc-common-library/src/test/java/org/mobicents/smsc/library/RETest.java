package org.mobicents.smsc.library;

import static org.testng.Assert.*;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

/**
*
* @author sergey vetyutnev
* 
*/
public class RETest {
    @Test(groups = { "RegularExpr" })
    public void testRegularExpr() {
//        String expr = "^([1-9][1-9]|[0-9][1-9]|[1-9][0-9]).*";
        String expr = "^00[0-9].*";
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher("0011");
        boolean b1 = m.matches();

        m = p.matcher("01");
        boolean b2 = m.matches();

        m = p.matcher("1");
        boolean b3 = m.matches();

        m = p.matcher("0");
        boolean b4 = m.matches();

        m = p.matcher("012222");
        boolean b5 = m.matches();

        m = p.matcher("1022222");
        boolean b6 = m.matches();

        m = p.matcher("11223232");
        boolean b7 = m.matches();

        m = p.matcher("100212");
        boolean b8 = m.matches();

        m = p.matcher("0000000");
        boolean b9 = m.matches();

        m = p.matcher("");
        boolean b0 = m.matches();
    }

    @Test(groups = { "RegularExpr" })
    public void testRegularExpr2() {
        String expr = "^(152)|(AWCC)$";
        Pattern p = Pattern.compile(expr);

        Matcher m = p.matcher("152");
        boolean b1 = m.matches();

        m = p.matcher("15");
        boolean b2 = m.matches();

        m = p.matcher("1152");
        boolean b3 = m.matches();

        m = p.matcher("1522");
        boolean b4 = m.matches();

        m = p.matcher("152152");
        boolean b5 = m.matches();

        m = p.matcher("AWCC");
        boolean b6 = m.matches();

        m = p.matcher("1AWCC");
        boolean b7 = m.matches();

        m = p.matcher("AWCC152");
        boolean b8 = m.matches();

        m = p.matcher("0000000");
        boolean b9 = m.matches();

        m = p.matcher("");
        boolean b0 = m.matches();

        m = p.matcher("1");
        boolean b10 = m.matches();

        m = p.matcher("2");
        boolean b11 = m.matches();

        m = p.matcher("152152");
        boolean b12 = m.matches();
    }

    @Test(groups = { "RegularExpr" })
    public void testRegularExpr3() {
        String expr = "^(152)|(AWCC)|(Shayeri)$";
        Pattern p = Pattern.compile(expr);

        Matcher m = p.matcher("152");
        boolean b1 = m.matches();
        assertTrue(b1);

        m = p.matcher("15");
        boolean b2 = m.matches();
        assertFalse(b2);

        m = p.matcher("1152");
        boolean b3 = m.matches();
        assertFalse(b3);

        m = p.matcher("1522");
        boolean b4 = m.matches();
        assertFalse(b4);

        m = p.matcher("152152");
        boolean b5 = m.matches();
        assertFalse(b5);

        m = p.matcher("AWCC");
        boolean b6 = m.matches();
        assertTrue(b6);

        m = p.matcher("1AWCC");
        boolean b7 = m.matches();
        assertFalse(b7);

        m = p.matcher("AWCC152");
        boolean b8 = m.matches();
        assertFalse(b8);

        m = p.matcher("0000000");
        boolean b9 = m.matches();
        assertFalse(b9);

        m = p.matcher("");
        boolean b0 = m.matches();
        assertFalse(b0);

        m = p.matcher("1");
        boolean b10 = m.matches();
        assertFalse(b10);

        m = p.matcher("2");
        boolean b11 = m.matches();
        assertFalse(b11);

        m = p.matcher("152152");
        boolean b12 = m.matches();
        assertFalse(b12);

        m = p.matcher("Shayeri");
        boolean b13 = m.matches();
        assertTrue(b13);

        m = p.matcher("hayeri");
        boolean b14 = m.matches();
        assertFalse(b14);

        m = p.matcher("Shayer");
        boolean b15 = m.matches();
        assertFalse(b15);

    }

    @Test(groups = { "RegularExpr" })
    public void testRegularExpr4() {
        String expr = "^27.*";
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher("2711111");
        boolean b1 = m.matches();

        m = p.matcher("2");
        boolean b2 = m.matches();

        m = p.matcher("27");
        boolean b3 = m.matches();

        m = p.matcher("3700000");
        boolean b4 = m.matches();

        m = p.matcher("");
        boolean b5 = m.matches();

        m = p.matcher("200700");
        boolean b6 = m.matches();
    }

    @Test(groups = { "RegularExpr" })
    public void testRegularExpr5() {
        String expr = "^[0-9a-zA-Z \n]*"; // "^.*"
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher("2711111");
        boolean b1 = m.matches();

        m = p.matcher("2711111\n");
        boolean b2 = m.matches();

        m = p.matcher("27 11111\n");
        boolean b3 = m.matches();
    }

    @Test(groups = { "RegularExpr" })
    public void testRegularExpr51() {
        String expr = "^9370.*";
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher("9370");
        boolean b1 = m.matches();

        m = p.matcher("9370111");
        boolean b2 = m.matches();

        m = p.matcher("8370111");
        boolean b3 = m.matches();

        m = p.matcher("937");
        boolean b4 = m.matches();
    }

    @Test(groups = { "UnicodeDecode" })
    public void testUnicodeDecode() {
        Charset ucs2Charset = Charset.forName("UTF-16BE");
        byte[] bt = new byte[] { 0x06, 0x27, 0x06, 0x2e, 0x06, 0x2a, 0x06, 0x31, 0x00, 0x20, 0x06, 0x45, 0x06, 0x46, 0x00,
                0x20, 0x06, 0x27, 0x06, 0x44, 0x06, 0x2a, 0x06, 0x27, 0x06, 0x44, 0x06, 0x4a, 0x00, 0x00, 0x00, 0x31, 0x00,
                0x20, 0x06, 0x27, 0x06, 0x44, 0x06, 0x2c, 0x06, 0x48, 0x00, 0x00, 0x00, 0x32, 0x00, 0x20, 0x06, 0x27, 0x06,
                0x44, 0x06, 0x31, 0x06, 0x35, 0x06, 0x4a, 0x06, 0x2f };

        String s1 = new String(bt, ucs2Charset);
        char[] ch = s1.toCharArray();
        int[] ii1 = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            ii1[i] = ch[i];
        }
        
        int ggg=0;
        ggg++;
    }

    @Test(groups = { "TimeZone" })
    public void testTimeZone() {
        Date submitDate = new Timestamp(System.currentTimeMillis());
        int timeZone = submitDate.getTimezoneOffset();

        submitDate = new Date();
        timeZone = submitDate.getTimezoneOffset();
    }
    
    public byte[] dataB = new byte[] { 0x20, (byte) 0xac, 
            0x00, 0x20, 0x00, 0x39, 0x00, 0x20, 0x00, 0x78, 0x00, 0x40, 0x00, 0x68, 0x00,
            0x6f, 0x00, 0x73, 0x00, 0x74, 0x00, 0x2e, 0x00, 0x63, 0x00, 0x6f, 0x00, 0x6d };
    public byte[] dataB1 = new byte[] { 0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbd, 
            0x00, 0x20, 0x00, 0x39, 0x00, 0x20, 0x00, 0x78, 0x00, 0x40, 0x00, 0x68, 0x00,
            0x6f, 0x00, 0x73, 0x00, 0x74, 0x00, 0x2e, 0x00, 0x63, 0x00, 0x6f, 0x00, 0x6d };
    // 0000   20 ef bf bd 
    //        00 20 00 39 00 20 00 78 00 40 00 68
    // 0010   00 6f 00 73 00 74 00 2e 00 63 00 6f 00 6d
    public String dataS = "� 9 x@host.com";

    @Test(groups = { "TimeZone" })
    public void testEncoding() {
        Charset ucs2Charset = Charset.forName("UTF-16BE");

        byte[] res1 = dataS.getBytes(ucs2Charset);
        // 32, -84, 0, 32, 0, 57, 0, 32, 0, 120, 0, 64, 0, 104, 0, 111, 0, 115, 0, 116, 0, 46, 0, 99, 0, 111, 0, 109

        String x1 = new String(dataB, ucs2Charset);
        String x12 = new String(dataB1, ucs2Charset);
    }

}
