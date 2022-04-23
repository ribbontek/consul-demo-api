package com.ribbontek.consuldemo.config

import com.ribbontek.consuldemo.discovery.MapAPIClient
import com.ribbontek.consuldemo.discovery.QuestAPIClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDiscoveryClient
@EnableFeignClients(
    clients = [
        MapAPIClient::class,
        QuestAPIClient::class
    ]
)
class ConsulDiscoveryConfig
