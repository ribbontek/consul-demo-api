package com.ribbontek.consuldemo.generator

import com.ribbontek.consuldemo.discovery.QuestAPIClient
import com.ribbontek.consuldemo.model.Quest
import com.ribbontek.consuldemo.util.QuestFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

interface QuestGenerator {
    fun createQuest(): Quest
}

@Service
class QuestGeneratorImpl(
    private val questAPIClient: QuestAPIClient,
    private val publisher: ApplicationEventPublisher
) : QuestGenerator {

    override fun createQuest(): Quest {
        val command = QuestFactory.createQuestCommand()
        publisher.publishEvent(command) // save on local server
        questAPIClient.createQuest(command)
        return questAPIClient.getQuest(command.questId)
    }
}
