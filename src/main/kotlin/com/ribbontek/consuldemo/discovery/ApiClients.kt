package com.ribbontek.consuldemo.discovery

import com.ribbontek.consuldemo.controller.resource.MapResource
import com.ribbontek.consuldemo.controller.resource.QuestResource
import com.ribbontek.consuldemo.discovery.ConsulAPI.MAP_API
import com.ribbontek.consuldemo.discovery.ConsulAPI.QUEST_API
import org.springframework.cloud.openfeign.FeignClient

object ConsulAPI {
    // The NAME constant would normally be used in the feign clients below for other APIs to use & interact with this api
    const val NAME = "consul-demo-api"
    const val QUEST_API = "quest-api"
    const val MAP_API = "map-api"
}

@FeignClient(
    name = QUEST_API,
    contextId = "$QUEST_API.QuestAPIClient",
    path = QuestResource.PATH
)
interface QuestAPIClient : QuestResource

@FeignClient(
    name = MAP_API,
    contextId = "$MAP_API.MapAPIClient",
    path = MapResource.PATH
)
interface MapAPIClient : MapResource
