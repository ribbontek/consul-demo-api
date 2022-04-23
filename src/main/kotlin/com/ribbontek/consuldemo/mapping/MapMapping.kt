package com.ribbontek.consuldemo.mapping

import com.ribbontek.consuldemo.model.CreateMapCommand
import com.ribbontek.consuldemo.model.QuestMap
import com.ribbontek.consuldemo.util.utc

fun CreateMapCommand.toMap() =
    QuestMap(
        mapId = mapId,
        name = name,
        urlLocation = urlLocation,
        createdUtc = utc()
    )
