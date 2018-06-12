package com.alex.morgan.bearlist.list

import java.util.Random

import javax.inject.Inject

import dagger.Reusable

@Reusable
internal class BearNameGenerator @Inject
constructor(private val random: Random) {

    val randomBearName: String
        get() = NAMES[random.nextInt(NAMES.size)]

    companion object {

        private val NAMES = arrayOf(
            "Beary Manilow",
            "Ali McClaw",
            "Gunnbjorn",
            "Pat Bearnatar",
            "Cindy Clawford",
            "Clawdia",
            "Pooh",
            "Empress",
            "Halley Beary",
            "Jennifurr",
            "Katy Beary",
            "Beary Poppins",
            "Pawdrey Hepburn",
            "Bing Clawsby",
            "Bearman Mao",
            "Hairy Potter",
            "Jude Paw",
            "Paw Rudd",
            "Brother Bear",
            "Sister Bear",
            "Papa Bear",
            "Mama Bear",
            "Two-tall Grizzly",
            "Two-ton Grizzly",
            "Yogi",
            "Boo Boo",
            "Koda",
            "Ted",
            "Paddington",
            "Baloo",
            "Pawly Shore",
            "Bear Grylls",
            "Beary Larkin",
            "Paw McCartney",
            "Little Bear",
            "Grizzly Adams"
        )
    }

}
