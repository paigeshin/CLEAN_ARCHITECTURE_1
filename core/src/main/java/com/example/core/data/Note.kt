package com.example.core.data

//POJO Object, Plain Old Java Object
data class Note(
    var title: String,
    var content: String,
    var creationTime: Long,
    var updateTime: Long,
    var id: Long = 0
)