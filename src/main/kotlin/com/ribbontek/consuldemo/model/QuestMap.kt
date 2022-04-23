package com.ribbontek.consuldemo.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.ZonedDateTime
import java.util.UUID

@Schema(description = "The Map Model")
data class QuestMap(
    @Schema(description = "The UUID of the map")
    val mapId: UUID,
    @Schema(description = "The name of the map")
    val name: String,
    @Schema(description = "The url location for the map")
    val urlLocation: String? = null,
    @Schema(description = "The created datetime (UTC) of the map")
    val createdUtc: ZonedDateTime
)
