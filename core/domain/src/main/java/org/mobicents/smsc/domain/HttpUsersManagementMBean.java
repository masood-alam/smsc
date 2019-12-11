/*
 * Telestax, Open Source Cloud Communications Copyright 2011-2017,
 * Telestax Inc and individual contributors by the @authors tag.
 * See the copyright.txt in the distribution for a full listing of
 * individual contributors.
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

import javolution.util.FastList;

/**
*
* @author sergey vetyutnev
*
*/
public interface HttpUsersManagementMBean {

    FastList<HttpUser> getHttpUsers();

    HttpUser getHttpUserByName(String userName);

    /**
     * Creates the http user.
     *
     * @param userName the user name
     * @param password the password
     * @param aNetworkId the network ID
     * @return the http user
     * @throws Exception the exception
     */
    HttpUser createHttpUser(String userName, String password, int aNetworkId) throws Exception;

    HttpUser destroyHttpUser(String userName) throws Exception;

}
