package com.gads.crowdfunding.dashboard.recyclerviewtypes

import com.gads.crowdfunding.R

object DataManager {


     val cards  =  ArrayList<TypeCardViewRV>()

    val itemFundraising = ArrayList<TypeItemFundraising>()


     fun initializeCards(): ArrayList<TypeCardViewRV> {

        cards.add(0, TypeCardViewRV(0,
                            R.mipmap.ic_launcher,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            7,
                            3)
        )
        cards.add(1, TypeCardViewRV(1,
                            R.mipmap.ic_launcher,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            5,
                            3
        )
        )
        cards.add(2, TypeCardViewRV(2,
                            R.mipmap.ic_launcher,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            2,
                            3
        )
        )
        cards.add(3, TypeCardViewRV(3,
                            R.mipmap.ic_launcher,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            8,
                            3
        )
        )
        cards.add(4, TypeCardViewRV(4,
                            R.mipmap.ic_launcher,
                            "Urgently - needed",
                            "Urgent! For ophanage children xyz xyx vsdo ivsv sv sdoiv asvois dnvos;div svi; asvoi; asvsdvsdhjvb sdv sdv sidlvsd",
                            9,
                            3
        )
        )

         return cards
    }

    fun initializeItemFundraising(): List<TypeItemFundraising>{

        itemFundraising.add(0, TypeItemFundraising(0,
                            R.mipmap.ic_launcher,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(1, TypeItemFundraising(1,
                            R.mipmap.ic_launcher,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(2, TypeItemFundraising(2,
                            R.mipmap.ic_launcher,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(3, TypeItemFundraising(3,
                            R.mipmap.ic_launcher,
                            "Charles Chillwel",
                            30000)
        )
        itemFundraising.add(4, TypeItemFundraising(4,
                            R.mipmap.ic_launcher,
                            "Charles Chillwel",
                            30000)
        )


        return itemFundraising
    }
}


