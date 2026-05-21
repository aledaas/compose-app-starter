package com.aledaas.compose_app_starter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform