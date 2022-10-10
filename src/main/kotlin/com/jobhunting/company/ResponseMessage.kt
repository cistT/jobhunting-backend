package com.jobhunting.company

import org.springframework.http.HttpStatus

data class ResponseMessage(
    val status :Int,
    val message:HttpStatus
)