/*
 * Copyright (c) 2017 by Indian Eagle LLC.
 * All rights reserved. These materials are confidential and proprietary to Indian Eagle LLC. No part of this code may be reproduced, published
 * in any form by any means (electronic or mechanical, including photocopy or any information storage or retrieval system), nor may the materials
 * be disclosed to third parties, or used in derivative works without the express written authorization of Indian Eagle LLC.
 *
 */

package com.example.sql.dto


import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * User: Prakash
 * Date: 7/14/2017
 * Time: 2:42 PM
 */
@MappedSuperclass
class CompanyIdDTO extends BaseDTO {

    @Column(name = 'COMPANY_ID')
    Long companyId
}