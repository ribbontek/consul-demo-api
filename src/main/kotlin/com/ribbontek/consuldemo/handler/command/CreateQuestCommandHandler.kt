package com.ribbontek.consuldemo.handler.command

import com.ribbontek.consuldemo.handler.EventHandler
import com.ribbontek.consuldemo.mapping.toQuest
import com.ribbontek.consuldemo.model.CreateQuestCommand
import com.ribbontek.consuldemo.service.QuestService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class CreateQuestCommandHandler(
    private val questService: QuestService
) : EventHandler<CreateQuestCommand> {

    @EventListener
    override fun handle(event: CreateQuestCommand) {
        questService.addNewQuest(event.toQuest())
    }
}
