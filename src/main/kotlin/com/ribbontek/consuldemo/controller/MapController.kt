package com.ribbontek.consuldemo.controller

import com.ribbontek.consuldemo.controller.resource.MapResource
import com.ribbontek.consuldemo.model.CreateMapCommand
import com.ribbontek.consuldemo.model.QuestMap
import com.ribbontek.consuldemo.service.MapService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(MapResource.PATH)
class MapController(
    private val publisher: ApplicationEventPublisher,
    private val mapService: MapService
) : MapResource {
    override fun createMap(command: CreateMapCommand) {
        publisher.publishEvent(command)
    }

    override fun getMap(mapId: UUID): QuestMap {
        return mapService.findMapById(mapId)
    }

    override fun retrieveMaps(): List<QuestMap> {
        return mapService.retrieveMaps()
    }
}
