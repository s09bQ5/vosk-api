/*
 * Copyright 2020 Alpha Cephei Inc. & Doomsdayrs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vosk

import com.sun.jna.PointerType
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * 26 / 12 / 2022
 */
actual class SpeakerModel : Freeable, PointerType, AutoCloseable {

	/**
	 * Empty constructor for JNA
	 */
	constructor()

	@Throws(IOException::class)
	actual constructor(path: String) : super(
		LibVosk.vosk_spk_model_new(path) ?: throw ioException(path)
	)

	/**
	 * Constructor using a Path, will retrieve absolutePath
	 *
	 * @param path to batch model
	 */
	@Throws(IOException::class)
	constructor(path: Path) : this(path.absolutePathString())

	/**
	 * Constructor using a File, will retrieve absolutePath
	 *
	 * @param file to batch model
	 */
	@Throws(IOException::class)
	constructor(file: File) : this(file.absolutePath)

	actual override fun free() {
		LibVosk.vosk_spk_model_free(this)
	}

	override fun close() {
		free()
	}

}