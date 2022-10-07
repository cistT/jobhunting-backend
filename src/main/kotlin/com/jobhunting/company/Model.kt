package com.jobhunting.company

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.relational.core.mapping.Table
import org.springframework.jdbc.core.JdbcTemplate

@EntityScan
@Table(name="company")
class Model(private val jdbcTemplate: JdbcTemplate) {

    fun getCompanyData(userID:String):List<Company>{
        val sql = "SELECT * FROM company WHERE user_id = ?".trimIndent()
        val mapper=CompanyDataMapper()

        return jdbcTemplate.queryForStream(sql,mapper,userID).toList()
    }
    fun registerCompanyData(userID: String,company:Company){
        val sql="INSERT INTO company(user_id, id, name, homepage_url, adoption_url, explanatory_meeting_date, interview_date, internship_date, motivation, result) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
        jdbcTemplate.update(
            sql,
            userID,
            company.id,
            company.name,
            company.homepageURL,
            company.adoptionURL,
            company.explanatoryMeetingDate,
            company.interviewDate,
            company.internshipDate,
            company.motivation,
            company.result
        )
        return
    }
    fun deleteRegisteredCompany(userID: String,id:String){
        val sql="DELETE FROM company WHERE user_id = ? AND id = ?"
        jdbcTemplate.update(sql,userID,id)
        return
    }
}