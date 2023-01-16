package com.lpirro.core.util.glide

import android.graphics.Bitmap
import android.graphics.Color
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.nio.charset.Charset
import java.security.MessageDigest

private const val ID = "com.lpirro.core.util.glide.RemovePaddingTransformation"

class RemovePaddingTransformation : BitmapTransformation() {

    private val idBytes: ByteArray = ID.toByteArray(
        Charset.forName("UTF-8")
    )

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(idBytes)
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        var startX = 0
        loop@ for (x in 0 until toTransform.width) {
            for (y in 0 until toTransform.height) {
                if (toTransform.getPixel(x, y) != Color.TRANSPARENT) {
                    startX = x
                    break@loop
                }
            }
        }
        var startY = 0
        loop@ for (y in 0 until toTransform.height) {
            for (x in 0 until toTransform.width) {
                if (toTransform.getPixel(x, y) != Color.TRANSPARENT) {
                    startY = y
                    break@loop
                }
            }
        }
        var endX = toTransform.width - 1
        loop@ for (x in endX downTo 0) {
            for (y in 0 until toTransform.height) {
                if (toTransform.getPixel(x, y) != Color.TRANSPARENT) {
                    endX = x
                    break@loop
                }
            }
        }
        var endY = toTransform.height - 1
        loop@ for (y in endY downTo 0) {
            for (x in 0 until toTransform.width) {
                if (toTransform.getPixel(x, y) != Color.TRANSPARENT) {
                    endY = y
                    break@loop
                }
            }
        }

        val newWidth = endX - startX + 1
        val newHeight = endY - startY + 1

        return Bitmap.createBitmap(toTransform, startX, startY, newWidth, newHeight)
    }
}
