package com.kotlin.io.example

import org.apache.pulsar.io.core.Sink
import org.apache.pulsar.functions.api.Record
import org.apache.pulsar.io.core.SinkContext

class ExampleSink: Sink<Map<String, Any>> {

    override fun open(config: MutableMap<String, Any>, sinkContext: SinkContext?) {
        println("HELLO") // just here as an example
    }

    override fun write(record: Record<Map<String, Any>>) {
        // write something        
    }

    override fun close() {
        // close something        
    }
}