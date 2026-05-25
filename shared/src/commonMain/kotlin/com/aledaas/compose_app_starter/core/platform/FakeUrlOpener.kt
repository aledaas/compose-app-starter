package com.aledaas.compose_app_starter.core.platform

class FakeUrlOpener : UrlOpener {
    override fun open(url: String) {
        println("Opening URL: $url")
    }
}