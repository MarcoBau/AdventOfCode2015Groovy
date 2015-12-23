String input = new File('./input/Day3.txt').text

assert 2 == travel(">").size()
assert 4 == travel("^>v<").size()
assert 2 == travel("^v^v^v^v^v").size()
println("Visited houses = " + travel(input).size())

println "=========="

assert 3 == roboTravel("^v").size()
assert 3 == roboTravel("^>v<").size()
assert 11 == roboTravel("^v^v^v^v^v").size()
println("Visited houses with robot = " + roboTravel(input).size())

def travel(String input) {
    def x = 0
    def y = 0
    def travelMap = [:]

    travelMap.put("$x/$y", travelMap.getOrDefault("$x/$y", 0) + 1)

    def moveIt = { move ->
        switch (move) {
            case "^":
                x++
                break
            case "<":
                y++
                break
            case ">":
                y--
                break
            case "v":
                x--
                break
            default:
                println "???"
                break
        }
        travelMap.put("$x/$y", travelMap.getOrDefault("$x/$y", 0) + 1)
    }
    input.each moveIt
    travelMap
}

def roboTravel(String input) {
    def x = 0
    def y = 0
    def travelMap = [:]

    santaMove = []
    roboMove = []

    travelMap.put("$x/$y", travelMap.getOrDefault("$x/$y", 0) + 1)

    def moveIt = { move ->
        switch (move) {
            case "^":
                x++
                break
            case "<":
                y++
                break
            case ">":
                y--
                break
            case "v":
                x--
                break
            default:
                println "???"
                break
        }
        travelMap.put("$x/$y", travelMap.getOrDefault("$x/$y", 0) + 1)
    }

    for (int i = 0; i < input.size(); i++) {
        if (i % 2 == 0) {
            santaMove << input.charAt(i)
        } else {
            roboMove << input.charAt(i)
        }
    }

    santaMove.each moveIt
    x = 0
    y = 0
    roboMove.each moveIt

    travelMap
}