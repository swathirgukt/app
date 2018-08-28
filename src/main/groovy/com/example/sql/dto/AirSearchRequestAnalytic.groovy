/*
 * Copyright (c) 2017 by Indian Eagle LLC.
 * All rights reserved. These materials are confidential and proprietary to Indian Eagle LLC. No part of this code may be reproduced, published
 * in any form by any means (electronic or mechanical, including photocopy or any information storage or retrieval system), nor may the materials
 * be disclosed to third parties, or used in derivative works without the express written authorization of Indian Eagle LLC.
 *
 */

package com.example.sql.dto

import javax.persistence.*

/**
 * User: Prakash 
 * Date: 7/14/2017
 * Time: 2:42 PM
 */

@Entity
@Table(name = 'AIR_SEARCH_REQUEST_ANALYTIC')
class AirSearchRequestAnalytic extends CompanyIdDTO {

    @Column(name = 'REQUEST_DATE')
    @Temporal(TemporalType.TIMESTAMP)
    Date requestDate

    @Column(name = 'REQUEST_TIME')
    @Temporal(TemporalType.TIMESTAMP)
    Date requestTime

    @Column(name = 'TRIP_TYPE')
    String tripType

    @Column(name = 'RESPONSE_STATUS')
    Integer responseStatus

    @Column(name = 'ITINERARY_REQUESTED')
    Integer numberOfItineraryRequested

    @Column(name = 'TIME_TO_RESPOND')
    Integer timeToRespond

    @Column(name = 'NUMBER_OF_ITINERARY')
    Integer numberOfItinerary

    @Column(name = 'IP_ADDRESS')
    String ipAddress

    @Column(name = 'REQUEST_FROM')
    String requestFrom

    @Column(name = 'SEARCH_TYPE')
    String searchType

    @Column(name = 'TRACKING_CODE')
    String trackingCode

    @Column(name = 'ORIGIN')
    String origin

    @Column(name = 'ORIGIN_COUNTRY_CODE')
    String originCountryCode

    @Column(name = 'DESTINATION')
    String destination

    @Column(name = 'DESTINATION_COUNTRY_CODE')
    String destinationCountryCode

    @Column(name = 'DEPARTURE_DATE')
    @Temporal(TemporalType.TIMESTAMP)
    Date departureDate

    @Column(name = 'RETURN_DATE')
    @Temporal(TemporalType.TIMESTAMP)
    Date returnDate
}