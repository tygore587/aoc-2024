package day00

import core.BasePath
import java.io.File


private const val TestRun = true
private const val Day = "00"

private fun computePart1(input: List<String>): Number {
    return  0
}

private fun computePart2(input: List<String>): Number {
    return 0
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