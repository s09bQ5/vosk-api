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

/**
 * Batch model object
 *
 * 26 / 12 / 2022
 *
 * @constructor Creates the batch recognizer object
 */
expect class BatchModel @Throws(IOException::class) constructor(path: String) : Freeable {

	/**
	 *  Releases batch model object
	 */
	override fun free()

	/**
	 * Wait for the processing
	 */
	fun await()
}