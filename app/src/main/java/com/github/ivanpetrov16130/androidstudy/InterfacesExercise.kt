package com.github.ivanpetrov16130.androidstudy


class EncodedItem(val content: String) {}


class DecodedItem(val content: String) {}


class Coder {

    fun applyTo(item: Codable): EncodedItem? {
        if (item.hash.toInt() == item.hashCode()) {
            return EncodedItem(content = item.hash)
        }
        println("Codable item has some issues with hash!")
        return null
    }

}


class Decoder {

    fun applyTo(item: Decodable): DecodedItem? {
        when (item.hash.toInt()) {
            in 0..Int.MAX_VALUE -> return DecodedItem(content = item.hash)
            else -> {
                println("Deodable item has some issues with hash!")
                return null
            }
        }
    }

}


interface Disposable {

    fun dispose()

}


interface Codable {

    val hash: String

    fun encodeWith(coder: Coder)

}


interface Decodable {

    val hash: String

    fun decodeWith(decoder: Decoder)

}


open class Hashable {
    val hash: String = this.hashCode().toString()
}


class JsonRepresentation: Hashable(), Codable, Decodable {

    override fun encodeWith(coder: Coder) {
        println("${this.javaClass.simpleName} instance encoded to json")
        coder.applyTo(this)
    }

    override fun decodeWith(decoder: Decoder) {
        println("${this.javaClass.simpleName} instance decoded from json")
        decoder.applyTo(this)
    }

}


class UserProperty: Hashable(), Codable, Disposable {

    override fun encodeWith(coder: Coder) { println("User property encoded for storing") }

    override fun dispose() { println("User property disposed from storage") }

}


class Token: Hashable(), Decodable, Disposable {

    override fun decodeWith(decoder: Decoder) { println("Token decoded and ready for sending") }

    override fun dispose() { println("Token eliminated from Keystore") }

}