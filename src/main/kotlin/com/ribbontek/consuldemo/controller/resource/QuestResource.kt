package com.ribbontek.consuldemo.controller.resource

import com.ribbontek.consuldemo.model.CreateQuestCommand
import com.ribbontek.consuldemo.model.Quest
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

interface QuestResource {

    companion object {
        const val PATH = "/quests"
    }

    @Operation(summary = "Create a new quest")
    @RequestMapping(
        value = ["/_create"],
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createQuest(@Validated @RequestBody command: CreateQuestCommand)

    @Operation(summary = "Get a quest by id")
    @RequestMapping(
        value = ["/{questId}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getQuest(@PathVariable("questId") questId: UUID): Quest

    @Operation(summary = "Retrieve all the quests")
    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun retrieveQuests(): List<Quest>
}
