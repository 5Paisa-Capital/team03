package com.kirtikumarsapplication.app.appcomponents.utility

/**
 * Created by brain_atul.a on 11-10-2023.
 */
class ValidateAadharAlgo {
    companion object {
        var _d = arrayOf(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
            intArrayOf(1, 2, 3, 4, 0, 6, 7, 8, 9, 5),
            intArrayOf(2, 3, 4, 0, 1, 7, 8, 9, 5, 6),
            intArrayOf(3, 4, 0, 1, 2, 8, 9, 5, 6, 7),
            intArrayOf(4, 0, 1, 2, 3, 9, 5, 6, 7, 8),
            intArrayOf(5, 9, 8, 7, 6, 0, 4, 3, 2, 1),
            intArrayOf(6, 5, 9, 8, 7, 1, 0, 4, 3, 2),
            intArrayOf(7, 6, 5, 9, 8, 2, 1, 0, 4, 3),
            intArrayOf(8, 7, 6, 5, 9, 3, 2, 1, 0, 4),
            intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        )
        var _p = arrayOf(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
            intArrayOf(1, 5, 7, 6, 2, 8, 3, 0, 9, 4),
            intArrayOf(5, 8, 0, 3, 7, 9, 6, 1, 4, 2),
            intArrayOf(8, 9, 1, 6, 0, 4, 3, 5, 2, 7),
            intArrayOf(9, 4, 5, 3, 1, 2, 6, 8, 7, 0),
            intArrayOf(4, 2, 8, 6, 5, 7, 3, 9, 0, 1),
            intArrayOf(2, 7, 9, 3, 8, 0, 6, 4, 1, 5),
            intArrayOf(7, 0, 4, 6, 9, 1, 3, 2, 5, 8)
        )
        var _inv = intArrayOf(0, 4, 3, 2, 1, 5, 6, 7, 8, 9)

        fun validateVerhoeff(num: String): Boolean {
            var c = 0
            val myArray = StringToReversedIntArray(num)
            for (i in myArray.indices) {
                c = _d[c][_p[i % 8][myArray[i]]]
            }
            return c == 0
        }

        private fun StringToReversedIntArray(num: String): IntArray {
            var myArray = IntArray(num.length)
            for (i in 0 until num.length) {
                myArray[i] = num.substring(i, i + 1).toInt()
            }
            myArray = Reverse(myArray)
            return myArray
        }

        private fun Reverse(myArray: IntArray): IntArray {
            val reversed = IntArray(myArray.size)
            for (i in myArray.indices) {
                reversed[i] = myArray[myArray.size - (i + 1)]
            }
            return reversed
        }
    }
}