package com.jobhunting.company

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CompanyDataMapper:RowMapper<Company> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Company? {
        return Company(
            id=rs.getString("id"),
            name=rs.getString("name"),
            homepageURL=rs.getString("homepage_url"),
            adoptionURL=rs.getString("adoption_url"),
            explanatoryMeetingDate=rs.getDate("explanatory_meeting_date"),
            interviewDate=rs.getDate("interview_date"),
            internshipDate=rs.getDate("internship_date"),
            motivation=rs.getString("motivation"),
            result=rs.getString("result")
        )
    }
}