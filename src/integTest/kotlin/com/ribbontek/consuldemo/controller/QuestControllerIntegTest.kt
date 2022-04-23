package com.ribbontek.consuldemo.controller

import com.ribbontek.consuldemo.context.IntegrationTest
import com.ribbontek.consuldemo.controller.resource.QuestResource
import com.ribbontek.consuldemo.exception.model.QuestNotFoundException
import com.ribbontek.consuldemo.generator.QuestGenerator
import com.ribbontek.consuldemo.util.QuestFactory
import com.ribbontek.consuldemo.util.andPrint
import com.ribbontek.consuldemo.util.andStatusIsCreated
import com.ribbontek.consuldemo.util.andStatusIsNotFound
import com.ribbontek.consuldemo.util.andStatusIsOk
import com.ribbontek.consuldemo.util.buildMockMvc
import com.ribbontek.consuldemo.util.withJsonContent
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.web.context.WebApplicationContext
import java.util.UUID
import javax.inject.Inject

@IntegrationTest
class QuestControllerIntegTest {

    @Inject
    private lateinit var context: WebApplicationContext

    @Inject
    private lateinit var questGenerator: QuestGenerator

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = buildMockMvc(context)
    }

    @Test
    fun `get quest - success`() {
        val quest = questGenerator.createQuest()

        mockMvc.get(QuestResource.PATH + "/{id}", quest.questId)
            .andPrint()
            .andStatusIsOk()
            .andExpect {
                jsonPath("$.questId", equalTo(quest.questId.toString()))
                jsonPath("$.name", equalTo(quest.name))
                jsonPath("$.description", equalTo(quest.description))
                jsonPath("$.level", equalTo(quest.level.toString()))
                jsonPath("$.status", equalTo(quest.status.toString()))
                jsonPath("$.createdUtc", notNullValue())
            }
    }

    @Test
    fun `get quest - not found`() {
        val questId = UUID.randomUUID()

        mockMvc.get(QuestResource.PATH + "/{id}", questId)
            .andPrint()
            .andStatusIsNotFound()
            .andExpect {
                val exception = QuestNotFoundException(questId)
                jsonPath("$.code", equalTo(exception.code.name))
                jsonPath("$.message", equalTo(exception.message))
            }
    }

    @Test
    fun `get quests`() {
        questGenerator.createQuest()

        mockMvc.get(QuestResource.PATH)
            .andPrint()
            .andStatusIsOk()
            .andExpect {
                jsonPath("$.size()", greaterThan(0))
            }
    }

    @Test
    fun `create quest - success`() {
        val quest = QuestFactory.createQuestCommand()

        mockMvc.post(QuestResource.PATH + "/_create") {
            withJsonContent(quest)
        }
            .andPrint()
            .andStatusIsCreated()
    }
}
