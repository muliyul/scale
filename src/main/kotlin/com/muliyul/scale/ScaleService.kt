package com.muliyul.scale

import com.fasterxml.jackson.module.kotlin.*
import io.dropwizard.assets.*
import io.dropwizard.configuration.*
import io.dropwizard.core.*
import io.dropwizard.core.setup.*
import io.swagger.v3.jaxrs2.integration.resources.*
import ru.vyarus.dropwizard.guice.*

class ScaleService : Application<ScaleServiceConfig>() {
	override fun run(c: ScaleServiceConfig, e: Environment) {

	}

	override fun initialize(bootstrap: Bootstrap<ScaleServiceConfig>) {
		bootstrap.objectMapper.registerKotlinModule()

		bootstrap.configurationSourceProvider =
			SubstitutingSourceProvider(ResourceConfigurationSourceProvider(), EnvironmentVariableSubstitutor(false))

		bootstrap.addBundle(
			GuiceBundle.builder()
				.dropwizardBundles(AssetsBundle("/static", "/swagger", "swagger.html"))
				.extensions(
					OpenApiResource::class.java,
					AcceptHeaderOpenApiResource::class.java
				)
				.enableAutoConfig()
				.build()
		)
	}
}

fun main(args: Array<String>) = ScaleService().run(*args)
