package com.ribbontek.consuldemo.controller

import com.ribbontek.consuldemo.context.IntegrationTest
import com.ribbontek.consuldemo.controller.resource.MapResource
import com.ribbontek.consuldemo.controller.resource.QuestResource
import com.ribbontek.consuldemo.exception.model.MapNotFoundException
import com.ribbontek.consuldemo.generator.MapGenerator
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
class MapControllerIntegTest {

    @Inject
    private lateinit var context: WebApplicationContext

    @Inject
    private lateinit var mapGenerator: MapGenerator

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = buildMockMvc(context)
    }

    @Test
    fun `get map - success`() {
        val map = mapGenerator.createMap()

        mockMvc.get(MapResource.PATH + "/{id}", map.mapId)
            .andPrint()
            .andStatusIsOk()
            .andExpect {
                jsonPath("$.mapId", equalTo(map.mapId.toString()))
                jsonPath("$.name", equalTo(map.name))
                jsonPath("$.urlLocation", equalTo(map.urlLocation))
                jsonPath("$.createdUtc", notNullValue())
            }
    }

    @Test
    fun `get map - not found`() {
        val mapId = UUID.randomUUID()

        mockMvc.get(MapResource.PATH + "/{id}", mapId)
            .andPrint()
            .andStatusIsNotFound()
            .andExpect {
                val exception = MapNotFoundException(mapId)
                jsonPath("$.code", equalTo(exception.code.name))
                jsonPath("$.message", equalTo(exception.message))
            }
    }

    @Test
    fun `get maps`() {
        mapGenerator.createMap()

        mockMvc.get(MapResource.PATH)
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
