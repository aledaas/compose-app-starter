package com.aledaas.compose_app_starter.core.network

import io.ktor.client.HttpClient

class ApiClient(
    val httpClient: HttpClient,
    val config: ApiConfig
)