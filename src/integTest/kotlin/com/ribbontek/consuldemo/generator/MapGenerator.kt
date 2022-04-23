package com.ribbontek.consuldemo.generator

import com.ribbontek.consuldemo.discovery.MapAPIClient
import com.ribbontek.consuldemo.model.QuestMap
import com.ribbontek.consuldemo.util.MapFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

interface MapGenerator {
    fun createMap(): QuestMap
}

@Service
class MapGeneratorImpl(
    private val mapAPIClient: MapAPIClient,
    private val publisher: ApplicationEventPublisher
) : MapGenerator {

    override fun createMap(): QuestMap {
        val command = MapFactory.createMapCommand()
        publisher.publishEvent(command) // save on local server
        mapAPIClient.createMap(command)
        return mapAPIClient.getMap(command.mapId)
    }
}
