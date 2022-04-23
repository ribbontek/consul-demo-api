package com.ribbontek.consuldemo.model

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID
import javax.validation.constraints.Size

@Schema(description = "The Create Quest Model")
data class CreateQuestCommand(

    @Schema(description = "The UUID of the quest")
    val questId: UUID,

    @Schema(description = "The name of the quest")
    @Size(min = 1, max = 100)
    val name: String,

    @Schema(description = "The description of the quest")
    @Size(max = 255)
    val description: String? = null,

    @Schema(
        description = "The level of the quest",
        allowableValues = ["EASY", "MEDIUM", "HARD", "INSANE"]
    )
    val level: QuestLevel,

    @Schema(
        description = "The status of the quest",
        allowableValues = ["INACTIVE", "ACTIVE", "STARTED", "IN_PROGRESS", "COMPLETED"]
    )
    val status: QuestStatus
)
