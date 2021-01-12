package com.erej.a40k9thScoring

class RandomNames {

    private val prefixes = listOf<String>("Rogal", "Abbadon", "Assholeteep", "Robute", "Magnus", "Ahriman", "Nurgle", "Khorne", "Tzeentch", "Slaneesh", "Peter", "Vulkan")
    private val suffixes = listOf<String>(", The infinite", " Guilliman", ", The red", ", Chosen of Tzeentch", ", Chosen of Nurgle", ", Chosen of Slaneesh", ", Chosen of Khorne", " Turbo")

    fun getRandomName() : String{
        var name : String = ""
        name += prefixes[(prefixes.indices).random()]

        name += suffixes[(suffixes.indices).random()]

        return name
    }

}