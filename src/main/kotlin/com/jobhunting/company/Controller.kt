package com.jobhunting.company

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
class Controller(val jdbcTemplate: JdbcTemplate) {

    @GetMapping("/company/userID={userID}")
    fun getRegisteredCompany(
        @PathVariable("userID") userID: String
    ):CompanyData {
        return   CompanyData(companyData = Model(jdbcTemplate).getCompanyData(userID))
    }


    @PostMapping("/company/register/userID={userID}",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun registerCompany(
        @PathVariable("userID") userID: String,
        @RequestBody @Validated request:Company
    ){

        Model(jdbcTemplate).registerCompanyData(userID,request)
    }

    @DeleteMapping("/company/delete/userID={userID}",consumes = ["application/json"])
    @ResponseStatus(code=HttpStatus.OK)
    fun deleteCompany(
        @PathVariable("userID") userID: String,
        @RequestBody request: CompanyID
    ):ResponseMessage{
        Model(jdbcTemplate).deleteRegisteredCompany(userID,request.id)
        return ResponseMessage(200,HttpStatus.OK)
    }

}