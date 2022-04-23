package com.ribbontek.consuldemo.handler.command

import com.ribbontek.consuldemo.handler.EventHandler
import com.ribbontek.consuldemo.mapping.toMap
import com.ribbontek.consuldemo.model.CreateMapCommand
import com.ribbontek.consuldemo.service.MapService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class CreateMapCommandHandler(
    private val mapService: MapService
) : EventHandler<CreateMapCommand> {

    @EventListener
    override fun handle(event: CreateMapCommand) {
        mapService.addNewMap(event.toMap())
    }
}
