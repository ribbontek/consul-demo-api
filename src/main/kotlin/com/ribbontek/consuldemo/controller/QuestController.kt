package com.ribbontek.consuldemo.controller

import com.ribbontek.consuldemo.controller.resource.QuestResource
import com.ribbontek.consuldemo.model.CreateQuestCommand
import com.ribbontek.consuldemo.model.Quest
import com.ribbontek.consuldemo.service.QuestService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(QuestResource.PATH)
class QuestController(
    private val publisher: ApplicationEventPublisher,
    private val questService: QuestService
) : QuestResource {
    override fun createQuest(command: CreateQuestCommand) {
        publisher.publishEvent(command)
    }

    override fun getQuest(questId: UUID): Quest {
        return questService.findQuestById(questId)
    }

    override fun retrieveQuests(): List<Quest> {
        return questService.retrieveQuests()
    }
}
