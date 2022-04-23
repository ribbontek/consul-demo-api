package com.ribbontek.consuldemo.service

import com.ribbontek.consuldemo.exception.model.QuestNotFoundException
import com.ribbontek.consuldemo.model.Quest
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

interface QuestService {
    fun findQuestById(questId: UUID): Quest
    fun addNewQuest(quest: Quest)
    fun retrieveQuests(): List<Quest>
}

@Service
class QuestServiceImpl : QuestService {

    private val quests = ConcurrentHashMap<UUID, Quest>()

    override fun findQuestById(questId: UUID): Quest {
        return quests[questId] ?: throw QuestNotFoundException(questId)
    }

    override fun retrieveQuests(): List<Quest> = quests.values.toList()

    override fun addNewQuest(quest: Quest) {
        quests[quest.questId] = quest
    }
}
