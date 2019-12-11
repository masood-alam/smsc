/*
 * TeleStax, Open Source Cloud Communications  
 * Copyright 2012, Telestax Inc and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.smsc.domain;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

/**
*
* @author sergey vetyutnev
*
*/
public class SmscCongestionControlTest {

    @Test(groups = { "SmscCongestionControl" })
    public void testSmscCongestionControl() throws Exception {
        SmscCongestionControl smscCongestionControl = new SmscCongestionControl();

        assertFalse(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_4Threshold());

        smscCongestionControl.registerMaxActivityCount1_0BackToNormal();

        assertFalse(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_4Threshold());

        smscCongestionControl.registerMaxActivityCount1_0Threshold();

        assertTrue(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_4Threshold());

        smscCongestionControl.registerMaxActivityCount1_0BackToNormal();

        assertFalse(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_4Threshold());

        smscCongestionControl.registerMaxActivityCount1_0Threshold();
        smscCongestionControl.registerMaxActivityCount1_2Threshold();
        smscCongestionControl.registerMaxActivityCount1_4Threshold();

        assertTrue(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertTrue(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertTrue(smscCongestionControl.isMaxActivityCount1_4Threshold());

        smscCongestionControl.registerMaxActivityCount1_2BackToNormal();
        smscCongestionControl.registerMaxActivityCount1_4BackToNormal();

        assertTrue(smscCongestionControl.isMaxActivityCount1_0Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_2Threshold());
        assertFalse(smscCongestionControl.isMaxActivityCount1_4Threshold());

    }

}
