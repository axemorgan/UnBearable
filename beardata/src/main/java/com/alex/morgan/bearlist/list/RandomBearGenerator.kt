package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear
import dagger.Reusable
import java.util.ArrayList
import java.util.Random
import javax.inject.Inject

@Reusable
class RandomBearGenerator @Inject
constructor(private val nameGenerator: BearNameGenerator) : BearSource {

    override val allBears: Collection<Bear>
        get() {
            try {
                //Long operation going on here
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            val bears = ArrayList<Bear>()
            for (i in 0..49) {
                bears.add(this.randomBear())
            }
            return bears
        }

    private fun randomBear(): Bear {
        return Bear(
            nameGenerator.randomBearName,
            "https://placebear.com/"
                    + (random.nextInt(100) + 50) + "/"
                    + (random.nextInt(100) + 50) + ".jpg"
        )
    }

    companion object {

        private val random = Random()
    }
}
