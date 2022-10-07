package com.jobhunting.company

import java.util.*
import kotlin.jvm.Throws

data class Company constructor(
    val id:String,
    val name:String,
    val homepageURL: String?,
    val adoptionURL: String?,
    val explanatoryMeetingDate: Date?,
    val interviewDate: Date?,
    val internshipDate: Date?,
    val motivation: String?,
    val result:String
) {
    init{
        if(!(result=="合格"||result=="不合格"||result=="未定")){
            throw Exception("resultは合格もしくは不合格もしくは未定のみです")
        }
    }
}