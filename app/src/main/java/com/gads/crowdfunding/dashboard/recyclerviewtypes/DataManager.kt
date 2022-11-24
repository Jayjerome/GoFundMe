package com.gads.crowdfunding.dashboard.recyclerviewtypes

import com.gads.crowdfunding.R

object DataManager {


     val cards  =  ArrayList<TypeCardViewRV>()

    val itemFundraising = ArrayList<TypeItemFundraising>()


     fun initializeCards(): ArrayList<TypeCardViewRV> {

        cards.add(0, TypeCardViewRV(0,
                            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3)
        )
        cards.add(1, TypeCardViewRV(1,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
            35000,
            20000,
            3
        )
        )
        cards.add(2, TypeCardViewRV(2,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",

            35000,
            20000,
            3
        )
        )
        cards.add(3, TypeCardViewRV(3,
            R.drawable.example_image,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            35000,
                          20000,
                               3
        )
        )
        cards.add(4, TypeCardViewRV(4,
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
}


