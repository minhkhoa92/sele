/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mytest

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OkHttpUnitTest {

  @Test
  fun `test ok http should return google request with no problem`() {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://www.google.de")
        .build()
    var erfolg = true

    client.newCall(request).execute().use { response ->
      if (!response.isSuccessful) erfolg = false

      for ((name, value) in response.headers) {
        println("$name: $value")
      }

      println(response.body!!.string())
    }
    Assertions.assertTrue(erfolg)
  }
}

