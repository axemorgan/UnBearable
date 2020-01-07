package com.alex.morgan.bearlist.hotkeys

import android.app.Activity
import android.os.Bundle


/**
 * Symbols Glossary
 *
 * Command - ⌘
 * Shift - ⇧
 * Control - ⌃
 * Option - ⌥
 * Delete - ⌫
 * Return - ⏎
 * Tab - ⇥
 */


@Suppress("unused")
object Hotkeys {

    /**
     * Find Actions - ⇧⌘A
     * Hot keys and menu options perform IntelliJ Actions.  Every button, menu, and keystroke action
     * can be found and performed through the Find Action dialog.
     */
    fun warmUp() {
        // TODO Sync gradle without pressing the button
        // TODO Turn off line numbers
        // TODO Invalidate caches and restart


        /** ⌥ + arrow - navigate over words */
        /** ⌘ + arrow - navigate to the start/end of a line */
        // TODO navigate whole words, and whole lines
    }


    /** Optimize Imports - ⌃⌥O */
// TODO remove these unused imports
//import com.alex.morgan.bearlist.Bear
//import com.alex.morgan.bearlist.BuildConfig

//fun     makeItPretty( howPretty : Int )
//{
//
//    /** Reformat Code - ⌥⌘L */
////     TODO make this pretty
//
//        makeItPretty(   11
//        )
//}

    /** Quick Fix - ⌥⏎
     * Why ever code anything by hand again?
     */
    fun quickFix() {
        // TODO simplify this
        val tautology = true && true

        // TODO simplify this
        if (tautology) {
            warmUp()
        }

        // TODO make this a val
        var s = ""
        // TODO remove the safe call
        s?.hashCode()
    }


    fun linesAndWords() {

        /** Delete Line - ⌘⌫ */
        // TODO delete this todo


        /** Delete Word - ⌥⌫ */
        // TODO delete these words
        // Prose
        // camelCase
        // PascalCase
        // snake_case
        // hyphenated-words


        var i = 0
        /** Duplicate Line - ⌘D */
        // TODO increment i a few more times
        i++
        print(i)

        /** Join Lines - ⌃⇧J */
        // TODO put this mess all on one line
        val bigString = "ABCD" +
                "EFG" +
                "HIJK" +
                "LMNOP" +
                "QRS" +
                "TUV" +
                "WXY" +
                "Z"


        /** Extend/Reduce Selection - ⌥ + arrow */
        // TODO select each block
        val lambda = {
            if (true) {
                val expression = (1 + 1) - (2)
            } else {

            }
        }


        /** Move Line Up/Down - ⌥⇧ + arrow */
        // TODO fix the order of this list
        val list = mutableListOf<Int>()
        list.add(3)
        list.add(2)
        list.add(4)
        list.add(5)
        list.add(1)
        println(list)
    }


    @Suppress("UNUSED_VARIABLE", "RedundantOverride")
    fun messyActivity() {

        /** Move Statement Up/Down - ⌥⇧ + arrow */
        // TODO organize these lifecycle methods
        val mActivity = object : Activity() {

            override fun onPause() {
                super.onPause()
            }

            override fun onResume() {
                super.onResume()
            }

            override fun onDestroy() {
                super.onDestroy()
            }

            override fun onCreate(savedInstanceState: Bundle?) {
                // TODO super.onCreate() should be the first call
                this.actionBar?.title = "Hotkeys!"
                super.onCreate(savedInstanceState)
            }

        }
    }
}
