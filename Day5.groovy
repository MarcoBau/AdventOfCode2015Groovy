input = new File('./input/Day5.txt').text

assert true == nice("ugknbfddgicrmopn")
assert true == nice("aaa")
assert false == nice("jchzalrnumimnmhp")
assert false == nice("haegwjzuvuyypxyu")
assert false == nice("dvszwmarrgswjxmb")


assert true == nicer("qjhvhtzxzqqjkmpb")
assert true == nicer("xxyxx")
assert false == nicer("uurcxstgmygtbstg")
assert false == nicer("ieodomkazucvgmuy")

// println input.readLines().grep { nice(it) }.size()
println input.readLines().grep { nicer(it) }.size()

def nice(String input) {
    if (input.contains("ab") || input.contains("cd") || input.contains("pq") || input.contains("xy")) {
        return false
    }

    int countVowels = 0
    char previousChar
    boolean twice = false
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c.equals(previousChar)) {
            twice = true
        } else {
            previousChar = c
        }
        if ("aeiou".contains(Character.toString(c))) {
            countVowels++
        }
    }
    twice && countVowels >= 3
}

def nicer(String input) {
    char previousChar
    char prePreviousChar
    repeats = false
    hasPair = false

    previousPairs = []
    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);
        if (previousChar && previousPairs.contains("$previousChar$currentChar")) {
            hasPair = true
        }

        if (currentChar.equals(prePreviousChar)) {
            repeats = true
        }
        if (prePreviousChar && previousChar) {//Groovy  Truth an empty char is considered as false ;)
            previousPairs.add("$prePreviousChar$previousChar")
        }

        prePreviousChar = previousChar
        previousChar = currentChar

    }
    hasPair && repeats
}