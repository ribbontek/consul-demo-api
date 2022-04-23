package com.ribbontek.consuldemo.util

import com.ribbontek.consuldemo.model.CreateQuestCommand
import com.ribbontek.consuldemo.model.Quest
import java.util.UUID

object QuestFactory {

    fun quest() = Quest(
        questId = UUID.randomUUID(),
        name = FakerUtil.alphaNumeric(100),
        description = FakerUtil.alphaNumeric(255),
        level = FakerUtil.enum(),
        status = FakerUtil.enum(),
        createdUtc = utc()
    )

    fun createQuestCommand() = CreateQuestCommand(
        questId = UUID.randomUUID(),
        name = FakerUtil.alphaNumeric(100),
        description = FakerUtil.alphaNumeric(255),
        level = FakerUtil.enum(),
        status = FakerUtil.enum()
    )
}
