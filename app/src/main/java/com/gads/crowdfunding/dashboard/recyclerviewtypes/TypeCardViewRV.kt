package com.gads.crowdfunding.dashboard.recyclerviewtypes

data class TypeCardViewRV (
    var id : Int,
    var imageId : Int,
    var title : String,
    var description : String,
    var progress : Int,
    var time_left : Int
)