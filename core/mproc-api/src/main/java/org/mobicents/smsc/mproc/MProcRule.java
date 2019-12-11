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

package org.mobicents.smsc.mproc;

/**
*
* @author sergey vetyutnev
*
*/
public interface MProcRule extends MProcRuleMBean {

    void setId(int val);

    // rule matchers - they specifies if this rule processes a trigger

    /**
     * @return true if the mproc rule fits to a message for the phase SMSC GW receives SRI response from a local HLR in HR
     *         procedure
     */
    boolean matchesPostHrSri(MProcMessage message);

    /**
     * @return true if the mproc rule fits to a message when a message has just come to SMSC
     */
    boolean matchesPostArrival(MProcMessage message);

    /**
     * @return true if the mproc rule fits to a message before a message delivery will start
     */
    boolean matchesPostPreDelivery(MProcMessage message);

    /**
     * @return true if the mproc rule fits to a message when IMSI / NNN has been received from HLR (succeeded SRI response)
     */
    boolean matchesPostImsiRequest(MProcMessage message);

    /**
     * @return true if the mproc rule fits to a message when a message delivery was ended (success or permanent delivery failure)
     */
    boolean matchesPostDelivery(MProcMessage message);

    /**
     * @return true if the mproc rule fits to a message when a message has temporary delivery failure
     */
    boolean matchesPostDeliveryTempFailure(MProcMessage message);

    // rule processors - we will put code for processing there

    /**
     * the event occurs when SMSC GW receives SRI response from a local HLR in HR procedure
     */
    void onPostHrSri(MProcRuleRaProvider anMProcRuleRa, PostHrSriProcessor factory, MProcMessage message) throws Exception;

    /**
     * the event occurs when a message has just come to SMSC
     */
    void onPostArrival(MProcRuleRaProvider anMProcRuleRa, PostArrivalProcessor factory, MProcMessage message) throws Exception;

    /**
     * the event occurs before a message delivery will start
     */
    void onPostPreDelivery(MProcRuleRaProvider anMProcRuleRa, PostPreDeliveryProcessor factory, MProcMessage message) throws Exception;

    /**
     * the event occurs when IMSI / NNN has been received from HLR (succeeded SRI response)
     */
    void onPostImsiRequest(MProcRuleRaProvider anMProcRuleRa, PostImsiProcessor factory, MProcMessage message) throws Exception;

    /**
     * the event occurs when a message delivery was ended (success or permanent delivery failure)
     */
    void onPostDelivery(MProcRuleRaProvider anMProcRuleRa, PostDeliveryProcessor factory, MProcMessage message) throws Exception;

    /**
     * the event occurs when a message has temporary delivery failure
     */
    void onPostDeliveryTempFailure(MProcRuleRaProvider anMProcRuleRa, PostDeliveryTempFailureProcessor factory, MProcMessage message) throws Exception;

    // applying of rule parameters from CLI / GUI interfaces

    /**
     * this method must implement setting of rule parameters as for provided CLI string at the step of rule creation
     */
    void setInitialRuleParameters(String parametersString) throws Exception;

    /**
     * this method must implement setting of rule parameters as for provided CLI string at the step of rules modifying
     */
    void updateRuleParameters(String parametersString) throws Exception;
    
}
