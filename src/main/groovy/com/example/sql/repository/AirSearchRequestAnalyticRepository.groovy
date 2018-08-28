/*
 * Copyright (c) 2017 by Indian Eagle LLC.
 * All rights reserved. These materials are confidential and proprietary to Indian Eagle LLC. No part of this code may be reproduced, published
 * in any form by any means (electronic or mechanical, including photocopy or any information storage or retrieval system), nor may the materials
 * be disclosed to third parties, or used in derivative works without the express written authorization of Indian Eagle LLC.
 *
 */

package com.example.sql.repository

import com.example.sql.dto.AirSearchRequestAnalytic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AirSearchRequestAnalyticRepository extends JpaRepository<AirSearchRequestAnalytic, Long> {

    @Query("select count(*), origin, destination,originCountryCode,destinationCountryCode from AirSearchRequestAnalytic where requestDate between ?1 and ?2 group by origin, destination")
    List<String[]> findAnalyticInDates(Date  startDate, Date endDate)


    @Query("from AirSearchRequestAnalytic where requestDate between ?1 and ?2 and origin = ?3 and destination = ?4")
    List<AirSearchRequestAnalytic> findAnalyticBetweenDates(Date  startDate, Date endDate, String origin, String destination)

    List<AirSearchRequestAnalytic> findAirSearchRequestAnalyticByRequestDate(Date  requestDate)


}