package com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes

data class TypeCardViewRV (
    var id : Int,
    var imageId : Int,
    var title : String,
    var description : String,
    var target_amount : Int,
    var obtained_amount : Int,
    var time_left : Int
)