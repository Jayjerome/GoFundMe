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
                            "Church Building",
                            "We kindly ask for your help in funds that would assist us build at a new location",
            350000,
            10000,
            30)
        )
        cards.add(1, TypeItemDashBoad(1,
            R.drawable.example_image,
                            "Sick Relative",
                            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            100000,
            60000,
            12
        )
        )
        cards.add(2, TypeItemDashBoad(2,
            R.drawable.example_image,
                            "Orphanage visit",
                            "We are about to make a visit to a nearby orphanage. We kindly ask for you to donate anything to the address provided or funds",

            20000,
            13000,
            7
        )
        )
        cards.add(3, TypeItemDashBoad(3,
            R.drawable.example_image,
                            "Hospital expansion",
                            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
                            1250000,
                          670000,
                               67
        )
        )
        cards.add(4, TypeItemDashBoad(4,
            R.drawable.example_image,
                            "School Kitchen needed",
                            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            69000,
            34100,
            26
        )
        )

         return cards
    }

    fun initializeItemFundraising(): List<TypeItemFundraising>{

        itemFundraising.add(0, TypeItemFundraising(0,
                            R.drawable.example_image2,
                            "Charles Chillwel",
                            3000)
        )
        itemFundraising.add(1, TypeItemFundraising(1,
            R.drawable.example_image2,
                            "Jacob",
                            67000)
        )
        itemFundraising.add(2, TypeItemFundraising(2,
            R.drawable.example_image2,
                            "Peter Griffin",
                            3800)
        )
        itemFundraising.add(3, TypeItemFundraising(3,
            R.drawable.example_image2,
                            "Ruby Margret ",
                            2048)
        )
        itemFundraising.add(4, TypeItemFundraising(4,
            R.drawable.example_image2,
                            "James Barnabas",
                            4930)
        )
        itemFundraising.add(5, TypeItemFundraising(5,
            R.mipmap.ic_launcher,
            "West Keith",
            38903)
        )
        itemFundraising.add(6, TypeItemFundraising(6,
            R.drawable.example_image2,
            "Tony Star",
            24945)
        )
        itemFundraising.add(7, TypeItemFundraising(7,
            R.mipmap.ic_launcher,
            "George Brian",
            29456)
        )


        return itemFundraising
    }

    fun initializeProjects(): List<TypeItemProjects>{

        projects.add(0, TypeItemProjects(0,
            R.drawable.example_image,
            "Hospital Expansion",
            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            35000,
            20000,
            3,
        true)
        )
        projects.add(1, TypeItemProjects(1,
            R.drawable.example_image,
            "School Kitchen Needed",
            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            35000,
            20000,
            3,
            false
        )
        )
        projects.add(2, TypeItemProjects(2,
            R.drawable.example_image,
            "Church Building",
            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",

            35000,
            20000,
            3,
            true
        )
        )
        projects.add(3, TypeItemProjects(3,
            R.drawable.example_image,
            "Orphanage Visiting",
            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            35000,
            20000,
            3,
            false
        )
        )
        projects.add(4, TypeItemProjects(4,
            R.drawable.example_image,
            "Sick Relative",
            "Lorem ipsum dolor sit amet. Qui earum saepe et quod omnis hic fuga obcaecati sit voluptate aperiam. Ut quia labore non harum itaque ut maiores voluptas hic dolor ratione. Ea expedita accusantium ea architecto illum et quia molestias quo molestiae inventore.",
            35000,
            20000,
            3,
            true
        )
        )

        return projects
    }
}


