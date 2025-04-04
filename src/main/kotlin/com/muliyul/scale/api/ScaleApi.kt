package com.muliyul.scale.api

import jakarta.ws.rs.*
import jakarta.ws.rs.core.*
import java.io.*

@Path("/scale")
interface ScaleApi {

	@POST
	@Consumes("image/*")
	@Produces("image/png")
	fun scale(
		@BeanParam
		params: ScaleImageParams,
		imageStream: InputStream
	): ByteArray


}
