package com.gads.crowdfunding.dashboard.recyclerviewtypes

data class TypeItemProjects(
    var id : Int,
    var imageId : Int,
    var title : String,
    var description : String,
    var target_amount : Int,
    var obtained_amount : Int,
    var time_left : Int,
    var projectStatus : Boolean
)