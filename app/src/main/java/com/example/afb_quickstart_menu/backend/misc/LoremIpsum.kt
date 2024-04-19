package com.example.afb_quickstart_menu.backend.misc
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlin.random.Random



class LoremIpsum {

    companion object {
        private val lorem: Lorem = LoremIpsum.getInstance()

        fun loremWithLength(length: Int): String {
            return lorem.getWords(length)
        }
        fun loremName() {

        }
        fun loremParagraph(lengthMin: Int, lengthMax: Int): String {
            return lorem.getTitle(lengthMin, lengthMax)
        }

        fun sampahStringGenerator(length: Int): String {
            val randomSampah = arrayOf(
                " (Sampah) ",
                " (Ini sampah) ",
                " (Ini Juga Sampah) ",
                " (Masih Sampah) ",
                " \n(I̵n̵i̴ ̸S̴a̷m̵p̶a̵h̴ ̶T̷e̵r̷k̷u̶t̸u̶k̶) \n",
                " (Ini tidak sampah) "
            )

            var result = ""
            var i = 0
            while (i < length) {
                val randomer = randomSampah[Random.nextInt(0, randomSampah.size)]
                result += randomer
                i++
            }
            return result
        }

    }
}