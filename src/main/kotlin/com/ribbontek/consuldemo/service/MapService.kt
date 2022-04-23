package com.ribbontek.consuldemo.service

import com.ribbontek.consuldemo.exception.model.MapNotFoundException
import com.ribbontek.consuldemo.model.QuestMap
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

interface MapService {
    fun findMapById(mapId: UUID): QuestMap
    fun addNewMap(map: QuestMap)
    fun retrieveMaps(): List<QuestMap>
}

@Service
class MapServiceImpl : MapService {

    private val maps = ConcurrentHashMap<UUID, QuestMap>()

    override fun findMapById(mapId: UUID): QuestMap {
        return maps[mapId] ?: throw MapNotFoundException(mapId)
    }

    override fun retrieveMaps(): List<QuestMap> = maps.values.toList()

    override fun addNewMap(map: QuestMap) {
        maps[map.mapId] = map
    }
}
