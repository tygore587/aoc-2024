package day01

import core.BasePath
import java.io.File
import kotlin.math.abs


private const val TestRun = false
private const val Day = "01"

private fun getFirstAndSecondList(input: List<String>): Pair<List<Int>, List<Int>> {
    return input
        .map { it.split("   ") }
        .map { it[0].toInt() to it[1].toInt() }
        .unzip()
}

private fun computePart1(input: List<String>): Number {
    val lists = getFirstAndSecondList(input)

    return lists
        .first
        .sorted()
        .zip(lists.second.sorted())
        .sumOf { abs(it.first - it.second) }
}

private fun computePart2(input: List<String>): Number {
    val lists = getFirstAndSecondList(input)

    val secondListGroup = lists.second.groupBy { it }

    return lists
        .first
        .sumOf { it * secondListGroup.getOrDefault(it, emptyList()).count() }
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