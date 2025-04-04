package com.muliyul.scale

import ru.vyarus.dropwizard.guice.module.installer.feature.health.*
import java.net.*

class ConnectivityHealthCheck : NamedHealthCheck() {
	override fun getName(): String = "connectivity"

	override fun check(): Result = kotlin.runCatching {
		Inet4Address.getByName("1.1.1.1").isReachable(5000)
	}.map { reachable ->
		if (reachable) Result.healthy()
		else Result.unhealthy("Could not reach 1.1.1.1")
	}.getOrElse {
		Result.unhealthy(it)
	}
}
