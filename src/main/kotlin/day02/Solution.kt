package day02

import core.BasePath
import java.io.File
import kotlin.io.path.Path
import kotlin.math.abs


private const val TestRun = false
private const val Day = "02"

private fun isSafe(prevNumber: Int, currentNumber: Int, direction: Int): Pair<Boolean, Int> {
    val compareResult = prevNumber.compareTo(currentNumber)

    val resultDirection = if (direction == 0) {
        compareResult
    } else direction

    if (resultDirection != compareResult || abs(prevNumber - currentNumber) !in 1..3)
        return Pair(false, direction)

    return Pair(true, resultDirection)
}

private fun isSafePart01(inputRow: String): Boolean {
    val numbersWindows = inputRow.split(" ").map { it.toInt() }.windowed(2, 1, false)

    var direction = 0

    for (numbersWindow in numbersWindows) {
        val (safe, newDirection) = isSafe(numbersWindow[0], numbersWindow[1], direction)

        if (!safe) {
            return false
        }

        direction = newDirection
    }

    return true
}

private fun isSafePart02(inputRow: String): Boolean {
    val numbers = inputRow.split(" ")

    for (index in numbers.indices) {
        val testInput =  numbers.filterIndexed { numberIndex, _ -> numberIndex != index  }.joinToString(" ")

        if (isSafePart01(testInput))
            return true
    }

    return false
}

private fun computePart1(input: List<String>): Number {
    return input.count { isSafePart01(it) }
}

private fun computePart2(input: List<String>): Number {
    return input.count { isSafePart02(it) }
}


fun main() {
    val inputFileName = "$BasePath/day${Day}/" + if (TestRun) {
        "input_test.txt"
    } else "input.txt"

    val input = File(inputFileName).readLines()
    val solutionPart1 = computePart1(input)

    if (solutionPart1 != 0)
        println("Part 1: $solutionPart1")

    val solutionPart2 = computePart2(input)

    if (solutionPart2 != 0)
        println("Part 2: $solutionPart2")
}