package com.ribbontek.consuldemo.controller.resource

import com.ribbontek.consuldemo.model.CreateMapCommand
import com.ribbontek.consuldemo.model.QuestMap
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

interface MapResource {

    companion object {
        const val PATH = "/maps"
    }

    @Operation(summary = "Create a new map")
    @RequestMapping(
        value = ["/_create"],
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createMap(@Validated @RequestBody command: CreateMapCommand)

    @Operation(summary = "Get a map by id")
    @RequestMapping(
        value = ["/{mapId}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getMap(@PathVariable("mapId") mapId: UUID): QuestMap

    @Operation(summary = "Retrieve all the maps")
    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun retrieveMaps(): List<QuestMap>
}
