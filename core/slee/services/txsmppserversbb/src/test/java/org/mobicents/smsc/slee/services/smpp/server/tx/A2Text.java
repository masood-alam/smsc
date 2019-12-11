package org.mobicents.smsc.slee.services.smpp.server.tx;

import java.nio.charset.Charset;

import org.mobicents.protocols.ss7.map.api.smstpdu.DataCodingScheme;
import org.mobicents.protocols.ss7.map.api.smstpdu.UserDataHeader;
import org.mobicents.protocols.ss7.map.datacoding.GSMCharset;
import org.mobicents.protocols.ss7.map.smstpdu.ConcatenatedShortMessagesIdentifierImpl;
import org.mobicents.protocols.ss7.map.smstpdu.DataCodingSchemeImpl;
import org.mobicents.protocols.ss7.map.smstpdu.UserDataHeaderImpl;
import org.mobicents.smsc.library.MessageUtil;
import org.testng.annotations.Test;

public class A2Text {

    private byte[] data0 = { 0x43, 0x6f, 0x74, 0x37, 0x30, 0x74, 0x6d, 0x72, 0x3f, 0x3f, 0x20, 0x3f, 0x3f, 0x20, 0x3f, 0x3f,
            0x3f, 0x3f, 0x3f, 0x20, 0x3f, 0x3f, 0x3f, 0x3f, 0x3f, 0x3f, 0x2b, 0x3f, 0x01, 0x03, 0x00, 0x28, 0x29, 0x2a, 0x2b,
            0x2d, 0x2f, 0x02, 0x1b, 0x65, 0x11, 0x2e, 0x21, 0x2a, 0x3f, 0x24, 0x1b, 0x3c, 0x1b, 0x3e, 0x23, 0x2c, 0x3d, 0x1b,
            0x3d, 0x3f, 0x26, 0x25, 0x3c, 0x3e, 0x1b, 0x28, 0x1b, 0x29, 0x1b, 0x40, 0x1b, 0x14, 0x3f, 0x3f, 0x3f, 0x3f, 0x20,
            0x3f, 0x3f, 0x3f, 0x3f, 0x20, 0x3f, 0x3f, 0x3f, 0x3f };

    private byte[] data = { 0x43, 0x6f, 0x74, 0x37, 0x30, 0x74, 0x6d, 0x72, (byte) 0xd8, (byte) 0xb0, (byte) 0xd8, (byte) 0xa7,
            0x20, (byte) 0xd9, (byte) 0x87, (byte) 0xd9, (byte) 0x88, 0x20, (byte) 0xd8, (byte) 0xb1, (byte) 0xd8, (byte) 0xb3,
            (byte) 0xd8, (byte) 0xa7, (byte) 0xd9, (byte) 0x84, (byte) 0xd8, (byte) 0xa9, 0x20, (byte) 0xd8, (byte) 0xa7,
            (byte) 0xd8, (byte) 0xae, (byte) 0xd8, (byte) 0xaa, (byte) 0xd8, (byte) 0xa8, (byte) 0xd8, (byte) 0xa7,
            (byte) 0xd8, (byte) 0xb1, 0x2b, 0x3f, (byte) 0xc2, (byte) 0xa3, (byte) 0xc2, (byte) 0xa5, 0x40, 0x28, 0x29, 0x2a,
            0x2b, 0x2d, 0x2f, 0x24, (byte) 0xe2, (byte) 0x82, (byte) 0xac, 0x5f, 0x2e, 0x21, 0x2a, (byte) 0xe2, (byte) 0x80,
            (byte) 0x99, (byte) 0xc2, (byte) 0xa4, 0x5b, 0x5d, 0x23, 0x2c, 0x3d, 0x7e, 0x60, 0x26, 0x25, 0x3c, 0x3e, 0x7b,
            0x7d, 0x7c, 0x5e, (byte) 0xf0, (byte) 0x9f, (byte) 0x98, (byte) 0x80, 0x20, (byte) 0xf0, (byte) 0x9f, (byte) 0x98,
            (byte) 0x81, 0x20, (byte) 0xf0, (byte) 0x9f, (byte) 0x98, (byte) 0x82 };

    private static Charset utf8Charset = Charset.forName("UTF-8");
    private static Charset ucs2Charset = Charset.forName("UTF-16BE");
    private static Charset isoCharset = Charset.forName("ISO-8859-1");
    private static Charset isoArabic = Charset.forName("ISO-8859-6");
    private static Charset gsm7Charset = new GSMCharset("GSM", new String[] {});

    @Test
    public void testA1() throws Exception {
//        Charset isoArabic2 = Charset.forName("ISO-639-3");

        String msg1 = new String(data, utf8Charset);
        String msg2 = new String(data, ucs2Charset);
        String msg3 = new String(data, gsm7Charset);
        String msg4 = new String(data, isoArabic);

    }

    @Test
    public void testA2() throws Exception {
        String s1 = "0027961247";
        long mId = Long.parseLong(s1);
        String digDlvMessageId = String.format("%08X", mId);
//        String digDlvMessageId = Long.toHexString(mId).toUpperCase();
    }

    @Test
    public void testA3() throws Exception {
        DataCodingScheme dcs = new DataCodingSchemeImpl(0xF1);
        String msg = "Welcome to [thiopien\nPrices in EUR\n\nLocal calls from 2.19/min\nIncoming calls 1.29/min\nCalls home from 1.99/min\n\nSMS from 1.29\nData from 19.99/mb\n\n--Lufth";
        UserDataHeader udh = new UserDataHeaderImpl();
        ConcatenatedShortMessagesIdentifierImpl udhe = new ConcatenatedShortMessagesIdentifierImpl(false, 227, 2, 1);
        udh.addInformationElement(udhe);
        int messageLen = MessageUtil.getMessageLengthInBytes(dcs, msg, udh);
        int i1 = 0;
        i1++;
    }
}
