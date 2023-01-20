package com.looker.installer.installer

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.looker.core.common.SdkCheck
import com.looker.installer.utils.BaseInstaller
import java.io.File

internal class LegacyInstaller(context: Context) : BaseInstaller(context) {

	companion object {
		const val APK_MIME = "application/vnd.android.package-archive"
	}

	override suspend fun install(packageName: String, uri: Uri, file: File) {
		if (SdkCheck.isNougat) Intent.FLAG_GRANT_READ_URI_PERMISSION else 0
		val flags = if (SdkCheck.isNougat) Intent.FLAG_GRANT_READ_URI_PERMISSION else 0
		context.startActivity(
			Intent(Intent.ACTION_INSTALL_PACKAGE).setDataAndType(uri, APK_MIME).setFlags(flags)
		)
	}
}