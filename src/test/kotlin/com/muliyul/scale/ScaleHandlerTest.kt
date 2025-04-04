package com.muliyul.scale

import com.muliyul.scale.api.*
import org.junit.jupiter.api.Test
import javax.imageio.*
import kotlin.test.*

class ScaleHandlerTest {

	private val scaleHandler = ScaleHandler()

	private val imgStream by lazy(LazyThreadSafetyMode.PUBLICATION) {
		ClassLoader.getSystemResourceAsStream("sample.png") ?: error("Could not find sample.png")
	}

	@Test
	fun `should scale image based on the factor provided`() {
		val imgBytes = imgStream.use { it.readBytes() }
		val originalDimensions = getDimensions(imgBytes)

		val scaledImage = scaleHandler.scale(ScaleImageParams(2f), imgBytes.inputStream())

		val scaledDimensions = getDimensions(scaledImage)

		expect(scaledDimensions) {
			originalDimensions.first * 2 to originalDimensions.second * 2
		}
	}

	private fun getDimensions(img: ByteArray) =
		ImageIO.read(img.inputStream()).let { image ->
			image.width to image.height
		}
}
