package com.example.sql.repository

import com.example.sql.dto.CashBackAirline
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Swathi
 * On 8/20/2018
 * At 08:29
 */
interface CashBackAirlineRepository extends JpaRepository<CashBackAirline, Long> {

    List<CashBackAirline> findCashBackAirlineByActiveTrueAndCompanyId(Long companyId)
}
