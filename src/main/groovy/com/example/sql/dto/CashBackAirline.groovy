package com.example.sql.dto

import javax.persistence.*

/**
 * The DTO that holds CashBack details
 *
 * @author Swathi
 * On 8/20/2018
 * At 08:16
 */
@Entity
@Table(name = "CASH_BACK_AIRLINES")
class CashBackAirline extends CompanyIdDTO {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id
    @Column(name = "SOURCE")
    private String source
    @Column(name = "DESTINATION")
    private String destination
    @Column(name = "EXCLUDED_ROUTES")
    private String excludedRoutes
    @Column(name = "REFERRER")
    private String referrer
    @Column(name = "AIRLINE_CODE")
    private String airlineCode
    @Column(name = "TRIP_TYPE")
    private String tripType
    @Column(name = "CABIN_TYPE")
    private String cabinType
    @Column(name = "FARE_TYPE")
    private String fareType
    @Column(name = "ADULT_CASH_BACK_AMOUNT")
    private BigDecimal adultCashBackAmount
    @Column(name = "CHILD_CASH_BACK_AMOUNT")
    private BigDecimal childCashBackAmount
    @Column(name = "INFANT_CASH_BACK_AMOUNT")
    private BigDecimal infantCashBackAmount
    @Column(name = "ACTIVE")
    private Boolean active
    @Column(name = "SHOW_MAJOR_AIRLINE")
    private boolean showMajorAirline
}
