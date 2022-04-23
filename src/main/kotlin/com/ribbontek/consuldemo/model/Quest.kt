package com.ribbontek.consuldemo.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.ZonedDateTime
import java.util.UUID

@Schema(description = "The Quest Model")
data class Quest(
    @Schema(description = "The UUID of the quest")
    val questId: UUID,
    @Schema(description = "The name of the quest")
    val name: String,
    @Schema(description = "The description of the quest")
    val description: String? = null,
    @Schema(description = "The maps associated with the quest")
    val map: List<QuestMap>? = null,
    @Schema(description = "The level of the quest")
    val level: QuestLevel,
    @Schema(description = "The status of the quest")
    val status: QuestStatus,
    @Schema(description = "The created datetime (UTC) of the quest")
    val createdUtc: ZonedDateTime
)

enum class QuestLevel {
    EASY, MEDIUM, HARD, INSANE
}

enum class QuestStatus {
    INACTIVE, ACTIVE, STARTED, IN_PROGRESS, COMPLETED
}
