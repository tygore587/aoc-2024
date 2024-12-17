package day00

import core.BasePath
import java.io.File


private const val TestRun = true
private const val ExpectedTestValuePart1 = -1
private const val ExpectedTestValuePart2 = -1
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

    printOutput(1, solutionPart1, ExpectedTestValuePart1)

    val solutionPart2 = computePart2(input)

    printOutput(2, solutionPart2, ExpectedTestValuePart2)
}

private fun printOutput(part: Number, actualSolution: Number, expectedSolution: Number) {
    if (!TestRun) {
        println("Solution Part $part: $actualSolution")
    } else if (actualSolution == expectedSolution) {
        println("Part $part works!")
    } else {
        println("Part $part: Wrong value. Value was: $actualSolution | Expected $expectedSolution")
    }
}