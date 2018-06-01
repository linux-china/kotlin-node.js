external fun require(module: String): dynamic

fun main(args: Array<String>) {
    println("Hello JavaScript!")

    val express = require("express")
    val app = express()
    val amazon = Amazon()

    app.get("/") { _, res ->
        res.type("text/plain")
        val nick = "Jacky"
        res.send("Hi $nick, I am a beautiful butterfly.")
    }

    app.get("/amazon/:asin") { req, res ->
        res.type("text/plain")
        amazon.getAmazonPrice(req.params.asin as String) {
            res.send("Price is $it")
        }
    }

    app.listen(3000) {
        println("Listening on port 3000")
    }
}

