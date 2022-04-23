package com.ribbontek.consuldemo.mapping

import com.ribbontek.consuldemo.model.CreateQuestCommand
import com.ribbontek.consuldemo.model.Quest
import com.ribbontek.consuldemo.util.utc

fun CreateQuestCommand.toQuest() =
    Quest(
        questId = questId,
        name = name,
        description = description,
        level = level,
        status = status,
        createdUtc = utc()
    )
