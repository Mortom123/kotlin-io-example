package com.kotlin.io.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.pulsar.io.core.Sink
import org.apache.pulsar.functions.api.Record
import org.apache.pulsar.io.core.SinkContext
import org.apache.pulsar.io.core.annotations.FieldDoc

val mapper: ObjectMapper = jacksonObjectMapper()

data class SinkConfig(
    @FieldDoc(
        required = true,
        defaultValue = "",
        help = ""
    )
    val address: List<String>,
    @FieldDoc(
        required = true,
        defaultValue = "",
        help = ""
    )
    val nested: Map<String, Int>,
    )

inline fun <reified T : Any> parseFromMap(conf: Map<String, Any>): T {
    return mapper.readValue(mapper.writeValueAsString(conf), T::class.java)
}

class ExampleSink: Sink<Map<String, Any>> {

    override fun open(config: MutableMap<String, Any>, sinkContext: SinkContext?) {
        println(parseFromMap<SinkConfig>(config))
        println("HELLO") // just here as an example
    }

    override fun write(record: Record<Map<String, Any>>) {
        // write something        
    }

    override fun close() {
        // close something        
    }
}