@file:Suppress("unused")

package com.alex.morgan.bearlist.hotkeys


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

class Refactorings {

    init {
        /** Rename - ⇧F6 */
        // TODO rename this factorial function
        doMath(5)
    }


    fun doMath(n: Int): Int {
        /** Inline ⌥⌘N */
        // FIXME why did I think defining one was a good idea?  Remove this val
        val one = 1

        return when (n) {
            0 -> one
            else -> n * doMath(n - one)
        }
    }


    fun andOrOrOrNotAndOrNotOr(a: Boolean, b: Boolean): Boolean {
        /** Extract Variable - ⌥⌘V */
        // TODO simplify this with some local variables
        return (a && b) || (b || a) || !(a && b) || !(b || a)
    }


    fun doSafeMath(a: Int) {
        /** Extract Function - ⌥⌘M */
        // TODO extract this useful expression into a function
        doMath(if (a < 0) -a else a)
    }


    /** Surround With - ⌥⌘T */


    @Suppress("SimplifyNegatedBinaryExpression")
    fun get5(n: Int): Int {
        return if (!(n == 5)) {
            5
        } else {
            n
        }
    }

    /** Invert If Condition */
    /** Convert to Expression Body */
    /** Move to Companion Object */

}