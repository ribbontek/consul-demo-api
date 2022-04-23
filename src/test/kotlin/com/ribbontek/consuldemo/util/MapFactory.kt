package com.ribbontek.consuldemo.util

import com.ribbontek.consuldemo.model.CreateMapCommand
import com.ribbontek.consuldemo.model.QuestMap
import java.util.UUID

object MapFactory {

    fun map() = QuestMap(
        mapId = UUID.randomUUID(),
        name = FakerUtil.alphaNumeric(100),
        urlLocation = FakerUtil.alphaNumeric(255),
        createdUtc = utc()
    )

    fun createMapCommand() = CreateMapCommand(
        mapId = UUID.randomUUID(),
        name = FakerUtil.alphaNumeric(100),
        urlLocation = FakerUtil.alphaNumeric(255)
    )
}
