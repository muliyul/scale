package com.muliyul.scale

import com.muliyul.scale.api.*
import java.awt.*
import java.awt.image.*
import java.io.*
import javax.imageio.*
import kotlin.math.*

class ScaleHandler {

	fun scale(params: ScaleImageParams, imageStream: InputStream): ByteArray {
		val bufferedImage = imageStream.use { ImageIO.read(it) }

		val scaledImage = bufferedImage.getScaledInstance(
			(bufferedImage.width * params.factor).roundToInt(),
			(bufferedImage.height * params.factor).roundToInt(),
			Image.SCALE_SMOOTH
		)

		val bi = BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null), BufferedImage.TYPE_INT_RGB)
		bi.graphics.drawImage(scaledImage, 0, 0, null)

		return ByteArrayOutputStream().apply {
			ImageIO.write(bi, "png", this)
		}.toByteArray()
	}

}
