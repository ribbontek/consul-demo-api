package com.ribbontek.consuldemo.model

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@Schema(description = "The Create Map Model")
data class CreateMapCommand(
    @Schema(description = "The UUID of the map")
    val mapId: UUID,
    @Schema(description = "The name of the map")
    val name: String,
    @Schema(description = "The url location for the map")
    val urlLocation: String? = null
)
