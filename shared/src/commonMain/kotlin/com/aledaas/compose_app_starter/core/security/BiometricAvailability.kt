package com.aledaas.compose_app_starter.core.security

sealed interface BiometricAvailability {

    data object Available : BiometricAvailability

    data object NotAvailable : BiometricAvailability

    data object NotEnrolled : BiometricAvailability

    data object HardwareUnavailable : BiometricAvailability
}