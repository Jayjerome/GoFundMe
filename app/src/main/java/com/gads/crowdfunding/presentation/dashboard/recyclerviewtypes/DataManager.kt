package com.gads.crowdfunding.presentation.dashboard.recyclerviewtypes

import com.gads.crowdfunding.R

//Sample data to fill the recycler View
object DataManager {


     val cards  =  ArrayList<TypeItemDashBoad>()

    val itemFundraising = ArrayList<TypeItemFundraising>()

    val projects = ArrayList<TypeItemProjects>()


     fun initializeCards(): ArrayList<TypeItemDashBoad> {

        cards.add(0, TypeItemDashBoad(0,
                            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3)
        )
        cards.add(1, TypeItemDashBoad(1,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3
        )
        )
        cards.add(2, TypeItemDashBoad(2,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",

            35000,
            20000,
            3
        )
        )
        cards.add(3, TypeItemDashBoad(3,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            35000,
                          20000,
                               3
        )
        )
        cards.add(4, TypeItemDashBoad(4,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3
        )
        )

         return cards
    }

    fun initializeItemFundraising(): List<TypeItemFundraising>{

        itemFundraising.add(0, TypeItemFundraising(0,
                            R.drawable.example_image2,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(1, TypeItemFundraising(1,
            R.drawable.example_image2,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(2, TypeItemFundraising(2,
            R.drawable.example_image2,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(3, TypeItemFundraising(3,
            R.drawable.example_image2,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(4, TypeItemFundraising(4,
            R.drawable.example_image2,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(5, TypeItemFundraising(5,
            R.mipmap.ic_launcher,
            "Charles Chillwel",
            30000)
        )
        itemFundraising.add(6, TypeItemFundraising(6,
            R.drawable.example_image2,
            "Charles Chillwel",
            30000)
        )
        itemFundraising.add(7, TypeItemFundraising(7,
            R.mipmap.ic_launcher,
            "Charles Chillwel",
            30000)
        )


        return itemFundraising
    }

    fun initializeProjects(): List<TypeItemProjects>{

        projects.add(0, TypeItemProjects(0,
            R.drawable.example_image,
            "Urgently - needed",
            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3,
        true)
        )
        projects.add(1, TypeItemProjects(1,
            R.drawable.example_image,
            "Urgently - needed",
            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3,
            false
        )
        )
        projects.add(2, TypeItemProjects(2,
            R.drawable.example_image,
            "Urgently - needed",
            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",

            35000,
            20000,
            3,
            true
        )
        )
        projects.add(3, TypeItemProjects(3,
            R.drawable.example_image,
            "Urgently - needed",
            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3,
            false
        )
        )
        projects.add(4, TypeItemProjects(4,
            R.drawable.example_image,
            "Urgently - needed",
            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3,
            true
        )
        )

        return projects
    }
}


