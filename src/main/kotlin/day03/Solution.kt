package day03

import core.BasePath
import java.io.File


private const val TestRun = false
private const val ExpectedTestValuePart1 = 161
private const val ExpectedTestValuePart2 = 48
private const val Day = "03"


private fun computePart1(input: List<String>): Number {
    val regex = Regex("mul\\((\\d+),(\\d+)\\)");
    return input.sumOf {
        regex
            .findAll(it)
            .sumOf { match ->
                val (_, val1, val2) = match.groupValues

                val1.toInt() * val2.toInt()
            }
    }
}

private fun computePart2(input: List<String>): Number {
    val regex = Regex("mul\\((\\d+),(\\d+)\\)|don't\\(\\)|do\\(\\)");
    var multiply = true

    return input.sumOf {
        regex
            .findAll(it)
            .sumOf matchSum@{ match ->
                val (fullMatch, val1, val2) = match.groupValues

                if (fullMatch == "do()") {
                    multiply = true
                    return@matchSum 0
                } else if (fullMatch == "don't()") {
                    multiply = false
                    return@matchSum 0
                }

                if (multiply) {
                    val1.toInt() * val2.toInt()
                } else {
                    0
                }
            }
    }
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
        println("Part $part: works!")
    } else {
        println("Part $part: Wrong value. Value was: $actualSolution | Expected $expectedSolution")
    }
}