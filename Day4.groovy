import java.security.MessageDigest

input = "yzbqklnj"


def generateMD5(String s) {
    MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
}

int i

genMD5 = ""
while (!genMD5.startsWith("00000")) {
    i++
    genMD5 = generateMD5("$input$i")
}
println("$input $i $genMD5")
println "======="

while (!genMD5.startsWith("000000")) {
    i++
    genMD5 = generateMD5("$input$i")
}

println("$input $i $genMD5")