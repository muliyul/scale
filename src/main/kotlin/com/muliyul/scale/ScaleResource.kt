package com.muliyul.scale

import com.muliyul.scale.api.*
import jakarta.inject.*
import java.io.*

class ScaleResource @Inject constructor(
	private val scaleHandler: ScaleHandler
) : ScaleApi {
	override fun scale(params: ScaleImageParams, imageStream: InputStream) =
		scaleHandler.scale(params, imageStream)
}
