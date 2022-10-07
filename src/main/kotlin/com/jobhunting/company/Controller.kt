package com.jobhunting.company

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
class Controller(val jdbcTemplate: JdbcTemplate) {

    @GetMapping("/company/userID={userID}")
    fun getRegisteredCompany(
        @PathVariable("userID") userID: String
    ):CompanyData {
        return CompanyData(companyData=Model(jdbcTemplate).getCompanyData(userID))
    }

    @PostMapping("/company/register/userID={userID}")
    fun registerCompany(
        @PathVariable("userID") userID: String,
        @RequestBody request:Company
    ){
        Model(jdbcTemplate).registerCompanyData(userID,request)
    }

    @PostMapping("/company/delete/userID={userID}")
    fun deleteCompany(
        @PathVariable("userID") userID: String,
        @RequestBody request: CompanyID
    ){
        Model(jdbcTemplate).deleteRegisteredCompany(userID,request.id)
    }

}