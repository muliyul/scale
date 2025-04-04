package com.muliyul.scale.api

import jakarta.validation.constraints.*
import jakarta.ws.rs.*

data class ScaleImageParams(
	@field:QueryParam("factor")
	@field:Positive
	@field:NotNull
	@field:DefaultValue("1")
	var factor: Float = 1f
)
